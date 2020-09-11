package se.omegapoint.academy.tdd.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * LicensePlateValidatorTest - [description goes here]
 * Created: 2020-09-11
 * Author: Henrik Stensson, henrik.stensson@omegapoint.se
 */
public class LicensePlateValidatorTest {

    @Test
    public void testCreate() {

        LicensePlateValidator licensePlateValidator = new LicensePlateValidator();
        Assert.assertNotNull(licensePlateValidator);
    }

    @Test
    public void correct_license_plate_should_validate_true() {

        // Given
        LicensePlateValidator licensePlateValidator = new LicensePlateValidator();
        String correctLicensePlate = "ABC123";

        // When
        boolean valid = licensePlateValidator.validate(correctLicensePlate);

        // Then
        Assert.assertTrue(valid);
    }

    @Test
    public void incorrect_license_plate_should_validate_false() {

        // Given
        LicensePlateValidator licensePlateValidator = new LicensePlateValidator();
        String incorrectLicensPlate = "123123";

        // When
        boolean valid = licensePlateValidator.validate(incorrectLicensPlate);

        // Then
        Assert.assertFalse(valid);
    }
}
