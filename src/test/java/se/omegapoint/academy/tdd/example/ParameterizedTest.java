package se.omegapoint.academy.tdd.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    @Parameterized.Parameter(0)
    public int first;
    @Parameterized.Parameter(1)
    public int second;
    @Parameterized.Parameter(2)
    public int sum;

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3},
                {3, 4, 7},
                {7, 8, 15}
        });
    }

    @Test
    public void sumsCorrectly() {
        assertThat(first + second).isEqualTo(sum);
    }

}
