package com.example.project2.controller;

import com.example.project2.model.ApplicantModel;
import com.example.project2.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @GetMapping("/applicant")
    public String getAllApplicants(Model model){
        var applicants = applicantService.findAllApplicant();
        model.addAttribute("applicants", applicants);
        return "index";
    }

    @GetMapping("/applicant/search")
    public String searchApplicant(@RequestParam(name="name") String name, Model model) {
        var applicants = applicantService.findApplicantByName(name);
        model.addAttribute("applicants", applicants);
        return "index";
    }

    @GetMapping("/applicant/create")
    public String getCreateApplicant() {
        return "createapplicant";
    }

    @PostMapping("/applicant/create")
    public String postCreateApplicant(
            @RequestParam(name="name") String name,
            @RequestParam(name="email") String email,
            @RequestParam(name="password") String password
    ) {
        applicantService.createApplicant(new ApplicantModel(name, email, password));
        return "redirect:/applicant";
    }
}
