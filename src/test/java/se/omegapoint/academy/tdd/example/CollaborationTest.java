package se.omegapoint.academy.tdd.example;

import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CollaborationTest {

    private final HttpClient httpClient = mock(HttpClient.class);

    private final HealthChecker healthChecker = new HealthChecker(httpClient);

    @Before
    public void setupCollaborator() {
        when(httpClient.get(any())).thenReturn("OK");
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
