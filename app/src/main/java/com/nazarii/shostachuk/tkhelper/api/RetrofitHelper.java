package com.nazarii.shostachuk.tkhelper.api;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    public static final String BASE_URL = "http://192.168.56.101:8181/";

    public static ApiService getService() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.computation()))
                .baseUrl(BASE_URL)
                .client(createHttpClient())
                .build()
                .create(ApiService.class);
    }

    private static OkHttpClient createHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(7, TimeUnit.SECONDS)
                .readTimeout(7, TimeUnit.SECONDS)
                .writeTimeout(7, TimeUnit.SECONDS)
                .addInterceptor(new BasicAuthInterceptor("admin", "admin"))
                .addInterceptor(provideLoggingInterceptor())
                .build();
    }

    private static Interceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

// Token Authentication ;
//    public Response intercept(Interceptor.Chain chain) throws IOException {
//        Request original = chain.request();
//
//        Request.Builder builder = original.newBuilder().header("Authorization", authToken);
//
//        Request request = builder.build();
//        return chain.proceed(request);
//    }

    private static class BasicAuthInterceptor implements Interceptor {

        private String credentials;

        public BasicAuthInterceptor(String user, String password) {
            this.credentials = Credentials.basic(user, password);
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request authenticatedRequest = request.newBuilder()
                    .header("Authorization", credentials).build();
            return chain.proceed(authenticatedRequest);
        }

    }

    public abstract class NetworkConnectionInterceptor implements Interceptor {

        public abstract boolean isInternetAvailable();

        public abstract void onInternetUnavailable();

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!isInternetAvailable()) {
                onInternetUnavailable();
            }
            return chain.proceed(request);
        }
    }

}
