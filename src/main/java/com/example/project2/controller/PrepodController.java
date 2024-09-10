package com.example.project2.controller;

import com.example.project2.model.PrepodModel;
import com.example.project2.service.InMemoryPrepodImpl;
import com.example.project2.service.PrepodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/prepod")
public class PrepodController {

    private final PrepodService PrepodService;

    @Autowired
    public PrepodController(PrepodService PrepodService) {
        this.PrepodService = PrepodService;
    }

    @GetMapping
    public String getPrepodAll(Model model){
        var prepods = PrepodService.findAllPrepod();
        model.addAttribute("prepods", prepods);
        return "index";
    }

    @GetMapping("/create")
    public String getCreatePrepod() {
        return "createPrepod";
    }

    @PostMapping("/create")
    public String postCreatePrepod(
            @RequestParam(name="name") String name,
            @RequestParam(name="email") String email,
            @RequestParam(name="password") String password
    ) {
        PrepodService.createPrepod(new PrepodModel(name, email, password));
        return "redirect:/prepod";
    }
}

