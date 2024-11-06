package com.project.solution;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.test.Gist;
import com.test.GistServiceFailedException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {

    public List<Gist> fetchGist(String user) throws IOException, GistServiceFailedException {
        String token = "";

        String url = "https://api.github.com/users/" + user + "/gists";

        HttpClient client = HttpClients.createDefault();
        HttpResponse response;

        HttpGet httpGet = new HttpGet(url);

        httpGet.setHeader("Accept", "application/vnd.github+json");
        httpGet.setHeader("Authorization", "Bearer " + token);
        httpGet.setHeader("X-GitHub-Api-Version", "2022-11-28");

        try {
            response  = client.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String responseBody = EntityUtils.toString(response.getEntity());

                Gson gson = new Gson();
                Type gistListType = new TypeToken<List<Gist>>(){}.getType();
                return gson.fromJson(responseBody, gistListType);
            } else {
                throw new GistServiceFailedException("failed to get list, with status code " + response.getStatusLine().getStatusCode());
            }
        } catch (IOException | GistServiceFailedException e) {
            throw new GistServiceFailedException("An error occurred while fetching gists: " + e);
        }
    }

    public static void main(String[] args) throws IOException, GistServiceFailedException {

        Main main = new Main();
        List<Gist> response = main.fetchGist("octocat");

        System.out.println(response);
    }
}