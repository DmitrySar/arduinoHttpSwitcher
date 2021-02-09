package diplom.arduinoHttpSwitcher.controller;

import diplom.arduinoHttpSwitcher.repository.SwitcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwitchController {

    @Autowired
    private SwitcherRepository repository;

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("history")
    public String getHistory(Model model) {
        model.addAttribute("history", repository.findAll());
        return "history";
    }

}
