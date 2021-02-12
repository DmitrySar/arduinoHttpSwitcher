package diplom.arduinoHttpSwitcher.controller;

import diplom.arduinoHttpSwitcher.entity.SwitchUtil;
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
        SwitchUtil switchUtil = new SwitchUtil(id);
        try {
            String res = new RestTemplate().getForObject(url + id, String.class);
            if (!switchUtil.isStatusRequest()) {
                Switcher sw = new Switcher(new SwitchUtil(id).nameGenerate(),
                        switchUtil.isSwitchOnRequest());
                sw.setResult(res);
                repository.save(sw);
            }
            return res;
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}
