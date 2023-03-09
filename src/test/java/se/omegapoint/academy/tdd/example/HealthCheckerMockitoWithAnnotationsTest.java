package se.omegapoint.academy.tdd.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HealthCheckerMockitoWithAnnotationsTest {

    @Mock
    private HttpClient httpClient;

    private HealthChecker healthChecker;


    @BeforeEach
    public void setupHealthChecker() {
        MockitoAnnotations.initMocks(this);
        healthChecker = new HealthChecker(httpClient);
        when(httpClient.get(any())).thenReturn("{\"status\": 0}");
    }

    @Test
    public void isHealthy_should_return_true() {
        // when
        boolean healthy = healthChecker.isHealthy();

        // then
        assertThat(healthy).isTrue();
    }


    @Test
    public void isHealthy_should_get_healthcheck() {
        // when
        healthChecker.isHealthy();

        // then
        verify(httpClient).get(URI.create("http://service-checker.internal/my-service/healthcheck"));
    }
}
