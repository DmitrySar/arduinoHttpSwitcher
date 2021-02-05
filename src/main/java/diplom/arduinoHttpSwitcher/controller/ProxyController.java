package diplom.arduinoHttpSwitcher.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ProxyController {

    @Value("${arduino.url}")
    private String url;

    @GetMapping("/{id}")
    public String getProxy(@PathVariable String id) {
        return "redirect:" + url + id;
    }
}
