package diplom.arduinoHttpSwitcher.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProxyController {

    @Value("${arduino.url}")
    private String url;

    @GetMapping("/{id}")
    public String getProxy(@PathVariable String id) {
        try {
            return new RestTemplate().getForObject(url + id, String.class);
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}
