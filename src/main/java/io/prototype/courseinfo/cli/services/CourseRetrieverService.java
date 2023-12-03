package io.prototype.courseinfo.cli.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CourseRetrieverService {

    private static final String URI = "https://app.pluralsight.com/profile/data/author/%s/all-content";

    private static final HttpClient CLIENT = HttpClient.newHttpClient();


    public String getCoursesFor(String authorName) {

        HttpRequest request = HttpRequest.newBuilder(java.net.URI.create(URI.formatted(authorName)))
                .GET().build();

        try {
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return switch(response.statusCode()) {
              case 200 -> response.body();
              case 404 -> "";
                default -> throw new RuntimeException("Pluralsight API call failed with status code: " + response.statusCode());
            };
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Could not retrieve course...", e);
        }

    }
}
