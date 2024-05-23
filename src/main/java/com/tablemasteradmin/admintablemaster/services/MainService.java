package com.tablemasteradmin.admintablemaster.services;

import com.tablemasteradmin.admintablemaster.HelperFunction.Popup;
import com.tablemasteradmin.admintablemaster.HelperFunction.PopupTypeEnum;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainService {
    protected final String mainUrl = "http://143.110.182.19:8080/";

    protected HttpResponse<String> getRequest(String url) throws IOException {
        if (!isInternetAvailable()) {
            handleNoInternetConnection();
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(mainUrl + url))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;

        try{
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            handleNoInternetConnection();
        }

        System.out.println(response);
        return response;
    }

    protected HttpResponse<String> postRequest(String url, String body) throws IOException {
        if (!isInternetAvailable()) {
            handleNoInternetConnection();
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(mainUrl + url))
                .method("POST", HttpRequest.BodyPublishers.ofString(body))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = null;

        try{
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            handleNoInternetConnection();
        }

        return response;
    }

    private boolean isInternetAvailable() {
        try {
            URL url = new URL("http://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            int responseCode = connection.getResponseCode();
            return (200 <= responseCode && responseCode <= 299);
        } catch (IOException e) {
            return false;
        }
    }

    private void handleNoInternetConnection() {
        Popup.showPopup(PopupTypeEnum.ERROR, "No Internet Connection. Please close app and run again", "No Internet Connection");
        System.exit(0);
    }
}
