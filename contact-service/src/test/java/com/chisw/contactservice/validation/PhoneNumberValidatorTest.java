package com.chisw.contactservice.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = ConfigurationForValidatorsTest.class)
class PhoneNumberValidatorTest {
    @MockBean
    ConstraintValidatorContext constraintValidatorContext;

    @Autowired
    PhoneNumberValidator phoneNumberValidator;

    @Test
    void isValid_mustReturnTrue_forValidPhoneNumbers() {
        //given
        String[] validPhoneNumbers = {
                "+1-212-456-7890",
                "+44 20 1234 5678",
                "+81 3 1234 5678",
                "+12124567890",
                "+442012345678",
                "+81312345678",
                "+1 (212) 456-7890",
                "+44 (20) 1234 5678",
                "+81 (3) 1234 5678",
                "+44-20-1234-5678",
                "+81-3-1234-5678",
                "+380 67 111 22 33",
                "+380671112233",
                "+380-67-111-22-33",
                "(+380) - (67) - (111) (2233)"
        };

        //then
        Arrays.stream(validPhoneNumbers)
                .forEach(phone -> assertTrue(phoneNumberValidator.isValid(phone, constraintValidatorContext)));
    }

    @Test
    void isValid_mustReturnFalse_forInvalidPhoneNumbers() {
        //given
        String[] invalidPhoneNumbers = {
                "+123", //Too short
                "+98765432109876543210", //Too long
                "+abcde", //Contains non-numeric characters
                "+1-212-4zzz56-7890", //Contains unsupported characters
                "(123) 456-7890" //Invalid format
        };

        //then
        Arrays.stream(invalidPhoneNumbers)
                .forEach(phone -> assertFalse(phoneNumberValidator.isValid(phone, constraintValidatorContext)));
    }
}