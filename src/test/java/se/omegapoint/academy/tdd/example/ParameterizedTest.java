package se.omegapoint.academy.tdd.example;


import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ParameterizedTest {
    public static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(3, 4, 7),
                Arguments.of(7, 8, 15),
                Arguments.of(0, 0, 0)
        );
    }

    @org.junit.jupiter.params.ParameterizedTest
    @MethodSource("testData")
    public void sumsCorrectly(int first, int second, int sum) {
        assertThat(first + second).isEqualTo(sum);
    }

}
