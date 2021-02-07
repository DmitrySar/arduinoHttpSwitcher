package diplom.arduinoHttpSwitcher.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class ProxyController {

    @Value("${arduino.url}")
    private String url;

    @GetMapping("/{id}")
    public String getProxy(@PathVariable String id) {
        return new RestTemplate().getForObject(url + id, String.class);
    }
}
