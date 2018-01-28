package se.omegapoint.academy.tdd.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.URI;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CollaborationWithAnnotations {

    @Mock
    private HttpClient httpClient;

    private TestSubject testSubject;

    @Before
    public void setupCollaborator() {
        when(httpClient.get(any())).thenReturn("OK");
    }

    @Before
    public void setupTestSubject() {
        testSubject = new TestSubject(httpClient);
    }

    @Test
    public void isHealthy_should_get_healthcheck() {
        // when
        testSubject.isHealthy();

        // then
        verify(httpClient).get(URI.create("/healthcheck"));
    }
}
