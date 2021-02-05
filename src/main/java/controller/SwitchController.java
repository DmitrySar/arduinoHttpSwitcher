package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwitchController {

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

}
