package com.example.project2.controller;

import com.example.project2.model.ApplicantModel;
import com.example.project2.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

    private final ApplicantService ApplicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.ApplicantService = applicantService;
    }

    @GetMapping
    public String getapplicantAll(Model model){
        var applicants = ApplicantService.findAllApplicant();
        model.addAttribute("applicants", applicants);
        return "index";
    }

    @GetMapping("/search")
    public String searchApplicant(@RequestParam(name="name") String name, Model model) {
        var applicants = ApplicantService.findApplicantByName(name);
        model.addAttribute("applicants", applicants);
        return "index";
    }

    @GetMapping("/create")
    public String getCreateapplicant() {
        return "createapplicant";
    }

    @PostMapping("/create")
    public String postCreateapplicant(
            @RequestParam(name="name") String name,
            @RequestParam(name="email") String email,
            @RequestParam(name="password") String password
    ) {
        ApplicantService.createApplicant(new ApplicantModel(name, email, password));
        return "redirect:/applicant";
    }
}