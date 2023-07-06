package com.chisw.contactservice.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberValid, String> {
    private static final String PHONE_NUMBER_REGEX = "^tel:[+]?(\\d{1,})(-\\d{1,})*$";
    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile(PHONE_NUMBER_REGEX);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(value);
        return matcher.matches();
    }
}
