package se.omegapoint.academy.tdd.example;


import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * LicensePlateValidatorTest - tests for LicensePlateValidator
 * Created: 2021-02-03
 * Updated: 2023-03-13
 * Authors:
 * Henrik Stensson
 * Carl Rosengren
 */
public class LicensePlateValidatorTest {
    LicensePlateValidator licensePlateValidator = new LicensePlateValidator();

    @Test

    public void givenThreeLettersThreeDigits_shouldBeValid() {
        // given
        licensePlateValidator = new LicensePlateValidator();
        String validLicensePlate = "ABC123";

        // when
        boolean result = licensePlateValidator.validate(validLicensePlate);

        // then
        assertTrue(result);
    }

    @Test
    public void givenSixLetters_shouldBeInvalid() {
        // given
        licensePlateValidator = new LicensePlateValidator();
        String invalidLicensePlate = "ABCDEF";

        // when
        boolean result = licensePlateValidator.validate(invalidLicensePlate);

        // then
        assertFalse(result);
    }

    @Test
    public void givenThreeLettersTwoDigitsOneLetter_shouldBeValid() {
        assertTrue(licensePlateValidator.validate("ABC12A"));
    }

    @Test
    public void givenTooShortOrLongPlate_shouldBeInvalid() {
        assertFalse(licensePlateValidator.validate("A"));
        assertFalse(licensePlateValidator.validate("AAAAAAAAAAAAA"));
    }

    @Test
    public void givenIllegalCharacters_shouldBeInvalid() {
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
    public void givenIllegalWords_shouldBeInvalid() {
        assertFalse(licensePlateValidator.validate("OND123"));
    }

    @Test
    public void givenInvalidPlateAndNotInDatabase_shouldBeInvalid() {
        // given
        final PrivatePlateDatabase privatePlateDatabase = mock(PrivatePlateDatabase.class);
        licensePlateValidator = new LicensePlateValidator(privatePlateDatabase);

        BDDMockito.given(privatePlateDatabase.lookup("TRUMP")).willReturn(false);

        assertFalse(licensePlateValidator.validateWithCustom("TRUMP"));
    }

    @Test
    public void givenInvalidPlateButIsInDatabase_shouldBeValid() {
        final PrivatePlateDatabase privatePlateDatabase = mock(PrivatePlateDatabase.class);
        licensePlateValidator = new LicensePlateValidator(privatePlateDatabase);

        BDDMockito.given(privatePlateDatabase.lookup("FORJOY")).willReturn(true);

        assertTrue(licensePlateValidator.validateWithCustom("FORJOY"));

    }
}
