package com.nazarii.shostachuk.tkhelper.utils.rxvalidator.validators;

import java.util.regex.Pattern;

public class EmailValidator extends PatternMatchesValidator {

    private static final String DEFAULT_MESSAGE = "Invalid email";

    public EmailValidator() {
        super(DEFAULT_MESSAGE, android.util.Patterns.EMAIL_ADDRESS);
    }

    public EmailValidator(String invalidEmailMessage) {
        super(invalidEmailMessage, android.util.Patterns.EMAIL_ADDRESS);
    }

    public EmailValidator(String invalidEmailMessage, Pattern pattern) {
        super(invalidEmailMessage, pattern);
    }
}
