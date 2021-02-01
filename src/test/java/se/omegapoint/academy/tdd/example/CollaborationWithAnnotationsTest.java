package se.omegapoint.academy.tdd.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CollaborationWithAnnotationsTest {

    @Mock
    private HttpClient httpClient;

    private HealthChecker healthChecker;


    @Before
    public void setupHealthChecker() {
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
