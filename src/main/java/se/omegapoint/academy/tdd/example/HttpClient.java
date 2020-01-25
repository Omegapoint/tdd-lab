package se.omegapoint.academy.tdd.example;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.net.URI;

public class HttpClient {

    public String get(URI uri) {

        CloseableHttpClient client = HttpClientBuilder.create().build();
        try {
            HttpResponse response = client.execute(new HttpGet(uri));
            return response.toString();
        } catch (IOException e) {
            throw new RuntimeException("VERY UNEXPECTED", e);
        }
    }
}
