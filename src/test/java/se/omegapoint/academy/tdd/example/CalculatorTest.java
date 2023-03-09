package se.omegapoint.academy.tdd.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setupCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void can_add() {
        // given
        final int x = 1;
        final int y = 1;

        // when
        final int sum = calculator.Add(x, y);

        // then
        assertThat(sum).isEqualTo(2);
    }
}
