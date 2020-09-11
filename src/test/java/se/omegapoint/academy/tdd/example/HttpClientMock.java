package se.omegapoint.academy.tdd.example;

import java.net.URI;

/**
 * HttpClientMock - [description goes here]
 * Created: 2020-09-11
 * Author: Henrik Stensson, henrik.stensson@omegapoint.se
 */
public class HttpClientMock extends HttpClient {
    @Override
    public String get(URI uri) {
        return "OK";
    }
}
