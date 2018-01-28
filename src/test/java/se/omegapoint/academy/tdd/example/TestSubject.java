package se.omegapoint.academy.tdd.example;

import java.net.URI;

public class TestSubject {

    private final HttpClient httpClient;

    public TestSubject(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void isHealthy() {
        httpClient.get(URI.create("/healthcheck"));
    }
}
