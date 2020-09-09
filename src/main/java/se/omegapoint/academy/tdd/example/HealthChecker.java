package se.omegapoint.academy.tdd.example;

import java.net.URI;

public class HealthChecker {

    private final HttpClient httpClient;

    public HealthChecker(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public boolean isHealthy() {
        return "OK".equals(httpClient.get(URI.create("http://service-checker.internal/my-service/healthcheck")));
    }
}
