package com.example.project2.service;

import com.example.project2.model.ApplicantModel;

import java.util.List;
import java.util.UUID;

public interface ApplicantService {
    List<ApplicantModel> findAllApplicant();
    ApplicantModel createApplicant(ApplicantModel Applicant);
    ApplicantModel updateApplicant(ApplicantModel Applicant);
    ApplicantModel findApplicantById(UUID id);
    void deleteApplicant(UUID id);
    List<ApplicantModel> findApplicantByName(String name);
}
