package com.example.glassfish.apis;

import com.example.glassfish.Students.Student;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Fitbit {

    public Fitbit() {

    }
    public JSONObject jsonRequest() throws IOException {
        String finalToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyM0JKNDMiLCJzdWIiOiI2QzM4VloiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJ3aHIgd251dCB3cHJvIHdzbGUgd3dlaSB3c29jIHdhY3Qgd3NldCB3bG9jIiwiZXhwIjoxNjM3NDk4NDI1LCJpYXQiOjE2Mzc0Njk2MjV9.sw-BEWHDVZC6KNRQP-QZDmz--G8yYBzUiN96DVy9qMA";
        URL url = new URL("https://api.fitbit.com/1/user/-/activities/steps/date/today/1w.json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyM0JKNDMiLCJzdWIiOiI2QzM4VloiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJ3aHIgd251dCB3cHJvIHdzbGUgd3dlaSB3c29jIHdhY3Qgd3NldCB3bG9jIiwiZXhwIjoxNjM3NDk4NDI1LCJpYXQiOjE2Mzc0Njk2MjV9.sw-BEWHDVZC6KNRQP-QZDmz--G8yYBzUiN96DVy9qMA");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;

        StringBuffer responser = new StringBuffer();
        while ((output = in.readLine()) != null) {
            responser.append(output);
        }

        in.close();

        JSONObject json = new JSONObject(responser.toString());

        System.out.println("Response:-" + responser.toString());

        conn.disconnect();

//        DefaultHttpClient httpclient = new DefaultHttpClient();
//        HttpPost post = new HttpPost("https://api.fitbit.com/1/user/-/activities/steps/data/today/1y.json");
//        post.setHeader(HttpHeaders.CONTENT_TYPE,"application/json");
//        post.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + finalToken);
//
//        JSONObject json=new JSONObject();
//// json.put ...
//// Send it as request body in the post request
//
//        StringEntity params=new StringEntity(json.toString());
//        post.setEntity(params);
//
//        HttpResponse response = httpclient.execute(post);
//        httpclient.getConnectionManager().shutdown();
//
//        return response.toString();
        return json;
    }

    public void apiSteps(Student student) throws IOException {
        String finalToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyM0JIREMiLCJzdWIiOiI2QzM4VloiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJyc29jIHJzZXQgcmFjdCBybG9jIHJ3ZWkgcmhyIHJudXQgcnBybyByc2xlIiwiZXhwIjoxNjM3NDYwMTQ3LCJpYXQiOjE2Mzc0MzEzNDd9._mn7-MYAuKOYDw1haOqsmZsC73gg6ZOt8d2FOVw8YwM";
        URL url = new URL("https://api.fitbit.com/1/user/-/activities/steps/date/today/1w.json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyM0JIREMiLCJzdWIiOiI2QzM4VloiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJyc29jIHJzZXQgcmFjdCBybG9jIHJ3ZWkgcmhyIHJudXQgcnBybyByc2xlIiwiZXhwIjoxNjM3NDYwMTQ3LCJpYXQiOjE2Mzc0MzEzNDd9._mn7-MYAuKOYDw1haOqsmZsC73gg6ZOt8d2FOVw8YwM");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;

        StringBuffer responser = new StringBuffer();
        while ((output = in.readLine()) != null) {
            responser.append(output);
        }

        int steps = 0;
        for (int i = 0; i < 7; i++) {
            JSONObject json = new JSONObject(responser.toString());

            JSONArray results = json.getJSONArray("activities-steps");

            JSONObject firstResult = results.getJSONObject(i);
            steps += Integer.parseInt(firstResult.getString("value"));
        }
        in.close();
        student.setSteps(steps);
    }

    public void apiDistance(Student student) throws IOException {
        String finalToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyM0JIREMiLCJzdWIiOiI2QzM4VloiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJyc29jIHJzZXQgcmFjdCBybG9jIHJ3ZWkgcmhyIHJudXQgcnBybyByc2xlIiwiZXhwIjoxNjM3NDYwMTQ3LCJpYXQiOjE2Mzc0MzEzNDd9._mn7-MYAuKOYDw1haOqsmZsC73gg6ZOt8d2FOVw8YwM";
        URL url = new URL("https://api.fitbit.com/1/user/-/activities/steps/date/today/1w.json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyM0JIREMiLCJzdWIiOiI2QzM4VloiLCJpc3MiOiJGaXRiaXQiLCJ0eXAiOiJhY2Nlc3NfdG9rZW4iLCJzY29wZXMiOiJyc29jIHJzZXQgcmFjdCBybG9jIHJ3ZWkgcmhyIHJudXQgcnBybyByc2xlIiwiZXhwIjoxNjM3NDYwMTQ3LCJpYXQiOjE2Mzc0MzEzNDd9._mn7-MYAuKOYDw1haOqsmZsC73gg6ZOt8d2FOVw8YwM");
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String output;

        StringBuffer responser = new StringBuffer();
        while ((output = in.readLine()) != null) {
            responser.append(output);
        }

        int distance = 0;
        for (int i = 0; i < 7; i++) {
            JSONObject json = new JSONObject(responser.toString());

            JSONArray results = json.getJSONArray("activities-distance");

            JSONObject firstResult = results.getJSONObject(i);
            distance += Integer.parseInt(firstResult.getString("value"));
        }
        in.close();
        student.setDistance(distance);
    }

}


