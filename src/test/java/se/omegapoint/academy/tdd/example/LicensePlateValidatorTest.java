package se.omegapoint.academy.tdd.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * LicensePlateValidatorTest - tests for LicensePlateValidator
 * Created: 2021-02-03
 * Updated: 2023-03-13
 * Authors:
 *  Henrik Stensson
 *  Carl Rosengren
 */
public class LicensePlateValidatorTest {
    HttpClient mockHttpClient = mock(HttpClient.class);

    @AfterEach
    public void noMoreInteractions(){
        Mockito.verifyNoMoreInteractions(
                mockHttpClient
        );
    }


    @Test
    public void testCreate(){

    }

    @Test
    public void correct_license_plate_should_validate_true() {
        // given
        // when
        // then

        // new Mock
        assertTrue(new LicensePlateValidator().isCorrect("AAA000"));
        // assertTrue(new LicensePlateValidator(mockHttpClient).isCorrect("AAA000"));

        Mockito.any();
        Matchers.any();
        Mockito.when(new LicensePlateValidator().isCorrect("Test")).thenReturn(true);
        BDDMockito.given(new LicensePlateValidator().isCorrect("Test")).willReturn(true);
    }

    @Test
    public void incorrect_license_plate_should_validate_false() {
        assertFalse(new LicensePlateValidator().isCorrect("AAAAAA"));

    }
}
