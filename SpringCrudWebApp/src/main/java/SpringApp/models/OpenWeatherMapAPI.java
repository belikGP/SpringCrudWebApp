package SpringApp.models;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class OpenWeatherMapAPI {
    public JSONObject getWeatherFromAPI(String city) {
        String apiKey = "7b7573541c82bd259960739cb3914c08";
        String url = "http://api.openweathermap.org/geo/1.0/direct?q=" + city +
                "&limit=5&appid=" + apiKey;

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        try {
            HttpResponse response = client.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            JSONObject data = new JSONArray(json).getJSONObject(0);

            double latitude = data.getDouble("lat");
            double longitude = data.getDouble("lon");

            String weatherUrl = "http://api.openweathermap.org/data/2.5/weather?lat=" + latitude +
                    "&lon=" + longitude + "&appid=" + apiKey;

            request = new HttpGet(weatherUrl);
            response = client.execute(request);
            json = EntityUtils.toString(response.getEntity());

            return new JSONObject(json);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }


}