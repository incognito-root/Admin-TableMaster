package com.tablemasteradmin.admintablemaster.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainService {
    protected final String mainUrl = "http://localhost:8080/";

    protected HttpResponse<String> getRequest(String url) throws IOException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(mainUrl + url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;

        try{
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(response);
        return response;
    }

    protected HttpResponse<String> postRequest(String url, String body) throws IOException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(mainUrl + url))
                .method("POST", HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = null;

        try{
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }
}