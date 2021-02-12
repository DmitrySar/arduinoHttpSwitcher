package diplom.arduinoHttpSwitcher.controller;

import diplom.arduinoHttpSwitcher.repository.SwitcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class SwitchController {

    @Autowired
    private SwitcherRepository repository;

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/history")
    public String getHistory(@RequestParam(defaultValue = "#{T(java.time.LocalDateTime).now().minusDays(1)}")
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                         LocalDateTime start,
                             @RequestParam(defaultValue = "#{T(java.time.LocalDateTime).now()}")
                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                     LocalDateTime stop,
                             Model model) {
        model.addAttribute("historySW1", repository.findByNameAndTimeBetween("SW1", start, stop));
        model.addAttribute("historySW2", repository.findByNameAndTimeBetween("SW2", start, stop));
        model.addAttribute("start", DateTimeFormatter.ISO_DATE_TIME.format(start));
        model.addAttribute("stop", DateTimeFormatter.ISO_DATE_TIME.format(stop));
        return "history";
    }

}
