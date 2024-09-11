package com.example.project2.controller;

import com.example.project2.model.PrepodModel;
import com.example.project2.service.InMemoryPrepodImpl;
import com.example.project2.service.PrepodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PrepodController {

    private final PrepodService prepodService;

    @Autowired
    public PrepodController(PrepodService prepodService) {
        this.prepodService = prepodService;
    }

    @GetMapping("/prepod")
    public String getPrepodAll(Model model){
        var prepods = prepodService.findAllPrepod();
        model.addAttribute("prepods", prepods);
        return "index";
    }

    @GetMapping("/prepod/search")
    public String searchPrepod(@RequestParam(name="name") String name, Model model) {
        var prepods = prepodService.findPrepodByName(name);
        model.addAttribute("prepods", prepods);
        return "index";
    }

    @GetMapping("/prepod/create")
    public String getCreatePrepod() {
        return "createPrepod";
    }

    @PostMapping("/prepod/create")
    public String postCreatePrepod(
            @RequestParam(name="name") String name,
            @RequestParam(name="email") String email,
            @RequestParam(name="password") String password
    ) {
        prepodService.createPrepod(new PrepodModel(name, email, password));
        return "redirect:/prepod";
    }
}
