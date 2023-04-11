package SpringApp.models;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class QuotesAPI {
    private static final String API_URL = "http://api.forismatic.com/api/1.0/";
    public JSONObject getQuoteFromAPI(){
        HttpClient client = HttpClientBuilder.create().build();

        HttpGet request = new HttpGet(API_URL+ "?method=getQuote&format=json&lang=ru");
        try {
            HttpResponse response = client.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            return new JSONObject(json);
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

}
