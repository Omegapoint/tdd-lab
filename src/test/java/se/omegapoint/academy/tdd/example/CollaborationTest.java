package se.omegapoint.academy.tdd.example;

import org.junit.Before;
import org.junit.Test;

import java.net.URI;

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
    public void isHealthy_should_get_healthcheck() {
        // when
        healthChecker.isHealthy();

        // then
        verify(httpClient).get(URI.create("/healthcheck"));
    }
}
