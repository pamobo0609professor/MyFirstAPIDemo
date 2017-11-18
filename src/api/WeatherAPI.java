/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.Gson;
import constant.APIDemoConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import model.Response;

/**
 *
 * @author laboratorio
 */
public class WeatherAPI implements Runnable {

    private Response getWeather() {
        URL theUrl;
        BufferedReader in = null;
        Response theResponse = null;

        try {
            theUrl = new URL(APIDemoConstants.DEMO_URL);

            final HttpURLConnection con
                    = (HttpURLConnection) theUrl.openConnection();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : "
                    + theUrl);

            System.out.println("Response Code : " + responseCode);

            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            
            final Gson gson = new Gson();
            theResponse = gson.fromJson(response.toString(), Response.class);

        } catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return theResponse;
    }

    @Override
    public void run() {
        Response res = getWeather();
        System.out.println(res.toString());
    }
}