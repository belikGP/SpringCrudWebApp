package SpringApp.controllers;

import SpringApp.models.OpenWeatherMapAPI;
import SpringApp.models.Person;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    @GetMapping
    private String setCity(){
        return "weather/setCity";
    }

    @GetMapping(("/city"))
    public String showWeather(Model model, @RequestParam("city") String city) {
        OpenWeatherMapAPI openWeatherMapAPI = new OpenWeatherMapAPI();
        JSONObject json = openWeatherMapAPI.getWeatherFromAPI(city);

        if (json != null) {
            model.addAttribute("openWeatherMapAPI", openWeatherMapAPI);
            JSONObject main = json.getJSONObject("main");
            model.addAttribute("cityName", json.getString("name"));
            model.addAttribute("temperature", main.getInt("temp"));
            JSONArray weather = json.getJSONArray("weather");
            JSONObject weatherObj = weather.getJSONObject(0);
            model.addAttribute("condition", weatherObj.getString("description"));
            model.addAttribute("pressure", main.getInt("pressure"));
            return "weather/show";
        } else {
            return "second/error";
        }
    }
}