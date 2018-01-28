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
public class CollaborationWithAnnotations {

    @Mock
    private HttpClient httpClient;

    private HealthChecker healthChecker;


    @Before
    public void setupHealthChecker() {
        healthChecker = new HealthChecker(httpClient);
    }

    @Test
    public void isHealthy_should_return_true() {
        // given
        when(httpClient.get(any())).thenReturn("OK");

        // when
        assertThat(healthChecker.isHealthy()).isTrue();
    }


    @Test
    public void isHealthy_should_get_healthcheck() {
        // when
        healthChecker.isHealthy();

        // then
        verify(httpClient).get(URI.create("/healthcheck"));
    }
}
