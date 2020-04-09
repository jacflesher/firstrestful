package com.myfirstrestfulservice.myFirstRestfulService.Jokes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class Joke {

        @GetMapping(value = "/joke", produces = MediaType.APPLICATION_JSON_VALUE)
        private GetJokeProperties joke () throws IOException {
            URL obj = new URL("https://sv443.net/jokeapi/v2/joke/any?type=twopart");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                ObjectMapper objectMapper = new ObjectMapper();
                GetJokeProperties myGetJokeProperties = objectMapper.readValue(response.toString(), GetJokeProperties.class);
                return myGetJokeProperties;
            } else {
                return null;
            }
        }

        @PutMapping(value="/joke", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
        private Object addJoke(@RequestBody PutJokeProperties putJoke) throws IOException {
            PutJokeProperties addJoke = new PutJokeProperties();
            FlagsProperties flags = new FlagsProperties();

            addJoke.setFormatVersion(2);
            addJoke.setCategory("Miscellaneous");
            addJoke.setType("twopart");
            addJoke.setFlagsProperties(flags);
            addJoke.setSetup(putJoke.getSetup());
            addJoke.setDelivery(putJoke.getDelivery());

            ObjectMapper addJokeMapper = new ObjectMapper();
            String addJokeStr = addJokeMapper.writeValueAsString(addJoke);
            System.out.println(addJokeStr);

            try {
                URL obj = new URL("https://sv443.net/jokeapi/v2/submit");
                HttpURLConnection con;
                con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("PUT");
                con.setRequestProperty("Content-Type", "application/json");
                con.setRequestProperty("User-Agent", "Mozilla/5.0");
                //con.setRequestProperty("Authorization", "Basic " + b64);
                con.setDoOutput(true);
                OutputStream outputStreamToRequestBody = con.getOutputStream();
                BufferedWriter httpRequestBodyWriter = new BufferedWriter(
                        new OutputStreamWriter(outputStreamToRequestBody));
                httpRequestBodyWriter.write(addJokeStr);
                httpRequestBodyWriter.flush();
                outputStreamToRequestBody.close();
                httpRequestBodyWriter.close();
                int responseCode = con.getResponseCode();
                System.out.println("GET Response Code :: " + responseCode);
                if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) { // success
                    BufferedReader in = new BufferedReader(new InputStreamReader(
                            con.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    return response.toString();
//                ObjectMapper objectMapper = new ObjectMapper();
//                GetJokeProperties myGetJokeProperties = objectMapper.readValue(lineRead.toString(), GetJokeProperties.class);
//                return myGetJokeProperties;
                }
            } catch (java.net.UnknownHostException e) {
                return e.getMessage();
            } catch (MalformedURLException e) {
                return e.getMessage();
            } catch (IOException e) {
                return e.getMessage();
            }


            return null;
        }
    }




