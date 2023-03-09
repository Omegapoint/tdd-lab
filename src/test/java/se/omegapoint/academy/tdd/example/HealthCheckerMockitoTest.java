package se.omegapoint.academy.tdd.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HealthCheckerMockitoTest {

    private final HttpClient httpClient = mock(HttpClient.class);

    private final HealthChecker healthChecker = new HealthChecker(httpClient);

    @BeforeEach
    public void setupCollaborator() {
        when(httpClient.get(any())).thenReturn("{\"status\":0}");
    }

    @Disabled
    @Test
    public void testHealthCheck() {
        final HealthChecker healthChecker = new HealthChecker(new HttpClient());

        assertThat(healthChecker.isHealthy()).isTrue();
    }

    @Test
    public void isHealthy_should_return_true() {
        // when
        boolean healthy = healthChecker.isHealthy();

        // then
        assertThat(healthy).isTrue();
    }

    @Test
    public void isHealthy_should_get_health_check() {
        // when
        healthChecker.isHealthy();

        // then
        verify(httpClient).get(URI.create("http://service-checker.internal/my-service/healthcheck"));
    }
}
