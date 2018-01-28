package se.omegapoint.academy.tdd.example;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionTest {

    private LowerCaseConverter converter;

    @Before
    public void setupList() {
        converter = new LowerCaseConverter();
    }

    @Test
    public void can_convert_to_lower_case() {
        // given
        Collection<String> strings = Collections.singletonList("HEJ");

        // when
        final Collection<String> lowercaselist = converter.toLowerCase(strings);

        // then
        assertThat(lowercaselist).contains("hej");
    }
}
