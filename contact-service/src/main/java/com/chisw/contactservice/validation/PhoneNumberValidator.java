package com.chisw.contactservice.validation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberValid, String> {
    private static final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        try {
            Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(value, null);
            boolean isValidNumber = phoneNumberUtil.isValidNumber(parsedNumber);

            return isValidNumber;

        } catch (NumberParseException e) {
            return false;
        }
    }
}
