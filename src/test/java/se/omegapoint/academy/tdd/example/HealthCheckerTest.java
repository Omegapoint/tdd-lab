package se.omegapoint.academy.tdd.example;

import org.junit.Assert;
import org.junit.Test;

/**
 * HealthCheckerTest - tests for health checker
 * Created: 2020-01-25
 * Author: Henrik Stensson, henrik.stensson@omegapoint.se
 */
public class HealthCheckerTest {

    @Test
    public void check_healthy_service_should_return_true() {

        // Given
        HttpClient httpClient = new HttpClient();
        HealthChecker healthChecker = new HealthChecker(httpClient);

        // When

        // Then
        Assert.assertTrue(healthChecker.isHealthy());
    }
}
