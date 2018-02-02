package se.omegapoint.academy.tdd.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.URI;

import static org.mockito.Matchers.any;

public class CollaborationTest {

    private final HttpClient httpClient = Mockito.mock(HttpClient.class);

    private final HealthChecker healthChecker = new HealthChecker(httpClient);

    @Before
    public void setupCollaborator() {
        Mockito.when(httpClient.get(any())).thenReturn("OK");
    }

    @Test
    public void isHealthy_should_get_healthcheck() {
        // when
        healthChecker.isHealthy();

        // then
        Mockito.verify(httpClient).get(URI.create("/healthcheck"));
    }
}
