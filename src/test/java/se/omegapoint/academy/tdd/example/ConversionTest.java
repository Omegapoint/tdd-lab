package se.omegapoint.academy.tdd.example;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionTest {

    private LowerCaseConverter lowerCaseConverter;

    @Before
    public void setupLowerCaseConverter() {
        lowerCaseConverter = new LowerCaseConverter();
    }

    @Test
    public void can_convert_to_lower_case() {
        // given
        final Collection<String> strings = Collections.singletonList("HEJ");

        // when
        final Collection<String> lowercaselist = lowerCaseConverter.toLowerCase(strings);

        // then
        assertThat(lowercaselist).containsExactly("hej");
    }
}
