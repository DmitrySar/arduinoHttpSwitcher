package diplom.arduinoHttpSwitcher.controller;

import diplom.arduinoHttpSwitcher.entity.Switcher;
import diplom.arduinoHttpSwitcher.repository.SwitcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProxyController {

    @Autowired
    private SwitcherRepository repository;

    @Value("${arduino.url}")
    private String url;

    @GetMapping("/{id}")
    public String getProxy(@PathVariable String id) {
        try {
            String res = new RestTemplate().getForObject(url + id, String.class);
            if (id.charAt(1) != '2') {
                Switcher sw = new Switcher("SW" + id.charAt(0),
                        id.charAt(1) == '1');
                sw.setResult(res);
                repository.save(sw);
            }
            return res;
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}
