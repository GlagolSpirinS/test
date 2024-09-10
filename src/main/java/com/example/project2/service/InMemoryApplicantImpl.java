package com.example.project2.service;

import com.example.project2.model.ApplicantModel;
import com.example.project2.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryApplicantImpl implements ApplicantService {

    private final ApplicantRepository ApplicantRepository;

    public InMemoryApplicantImpl(ApplicantRepository ApplicantRepository){
        this.ApplicantRepository = ApplicantRepository;
    }

    @Override
    public List<ApplicantModel> findAllApplicant() {
        return ApplicantRepository.findAllApplicant();
    }

    @Override
    public ApplicantModel createApplicant(ApplicantModel Applicant) {
        return  ApplicantRepository.createApplicant(Applicant);
    }

    @Override
    public ApplicantModel updateApplicant(ApplicantModel Applicant) {
        return  ApplicantRepository.updateApplicant(Applicant);
    }

    @Override
    public ApplicantModel findApplicantById(UUID id) {
        return ApplicantRepository.findApplicantById(id);
    }

    @Override
    public void deleteApplicant(UUID id) {
        ApplicantRepository.deleteApplicant(id);
    }

    @Override
    public List<ApplicantModel> findApplicantByName(String name) {
        return ApplicantRepository.findApplicantByName(name);
    }
}