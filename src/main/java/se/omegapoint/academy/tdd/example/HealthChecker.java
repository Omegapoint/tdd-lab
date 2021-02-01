package se.omegapoint.academy.tdd.example;

import org.json.JSONObject;

import java.net.URI;

public class HealthChecker {

    private final HttpClient httpClient;

    public HealthChecker(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public boolean isHealthy() {

        // Read json-data from remote service:
        String json = httpClient.get(URI.create("http://service-checker.internal/my-service/healthcheck"));

        // Parse json:
        JSONObject jsonObject = new JSONObject(json);
        int statusCode = jsonObject.getInt("status");

        // StatusCode 0 or 100 is OK
        return statusCode == 0 || statusCode == 100;
    }
}
