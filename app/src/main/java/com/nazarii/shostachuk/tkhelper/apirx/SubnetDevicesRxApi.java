package com.nazarii.shostachuk.tkhelper.apirx;

import com.nazarii.shostachuk.tkhelper.networktools.SubnetDevices;
import com.nazarii.shostachuk.tkhelper.networktools.subnet.Device;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class SubnetDevicesRxApi {
    public SubnetDevicesRxApi get() {
        return new SubnetDevicesRxApi();
    }

    public void doAction(String address) throws UnknownHostException {
        // Asynchronously
        SubnetDevices.fromIPAddress(InetAddress.getByName(address)).findDevices(new SubnetDevices.OnSubnetDeviceFound() {
            @Override
            public void onDeviceFound(Device device) {
                // Stub: Found subnet device
            }

            @Override
            public void onFinished(ArrayList<Device> devicesFound) {
                // Stub: Finished scanning
            }
        });
    }
}
