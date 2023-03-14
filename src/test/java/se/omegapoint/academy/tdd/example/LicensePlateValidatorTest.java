package se.omegapoint.academy.tdd.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * LicensePlateValidatorTest - tests for LicensePlateValidator
 * Created: 2021-02-03
 * Updated: 2023-03-13
 * Authors:
 *  Henrik Stensson
 *  Carl Rosengren
 */
public class LicensePlateValidatorTest {
    LicensePlateValidator licensePlateValidator = new LicensePlateValidator();

    @Test
    public void three_letters_three_digits_should_be_valid() {
        // given
        licensePlateValidator = new LicensePlateValidator();
        String validLicensePlate = "ABC123";

        // when
        boolean result = licensePlateValidator.validate(validLicensePlate);

        // then
        assertTrue(result);
    }

    @Test
    public void six_letters_should_be_invalid() {
        // given
        licensePlateValidator = new LicensePlateValidator();
        String invalidLicensePlate = "ABCDEF";

        // when
        boolean result = licensePlateValidator.validate(invalidLicensePlate);

        // then
        assertFalse(result);
    }

    @Test
    public void three_letters_two_digits_one_letter_should_be_valid() {
        assertTrue(licensePlateValidator.validate("ABC12A"));
    }

    @Test
    public void too_short_or_long_plate_should_be_invalid() {
        assertFalse(licensePlateValidator.validate("A"));
        assertFalse(licensePlateValidator.validate("AAAAAAAAAAAAA"));
    }

    @Test
    public void illegal_characters_should_be_invalid() {
        /*
        I - används ej, förväxlingsbar med J (handstil/uttal) och L (gement: l)
        O - Används inte som sista bokstav om det är 2 siffror och en fjärde bokstav, förväxlingarbar med 0
        Q - Förväxlingsbar med O
        V - Förväxlingsbar med U (handstil) och W (talspråk)
        (Tekniskt sett kan dessa användas på personliga skyltar)
         */

        assertFalse(licensePlateValidator.validate("ABI00A"));
        assertFalse(licensePlateValidator.validate("ABQ001"));
        assertFalse(licensePlateValidator.validate("ABV002"));
        assertFalse(licensePlateValidator.validate("ABC00O"));
    }

    @Test
    public void illegal_words_should_be_invalid() {
        assertFalse(licensePlateValidator.validate("OND123"));
    }
}
