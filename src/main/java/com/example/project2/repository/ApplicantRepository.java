package com.example.project2.repository;

import com.example.project2.model.ApplicantModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;


@Repository
public class ApplicantRepository {
    private final List<ApplicantModel> ApplicantS = new ArrayList<>();

    public List<ApplicantModel> findAllApplicant(){
        return ApplicantS;
    }

    public ApplicantModel findApplicantById(UUID id) {
        return ApplicantS.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public ApplicantModel createApplicant(ApplicantModel Applicant){
        ApplicantS.add(Applicant);
        return Applicant;
    }

    public ApplicantModel updateApplicant(ApplicantModel Applicant){
        var ApplicantIndex = IntStream.range(0, ApplicantS.size())
                .filter(index-> ApplicantS.get(index).getEmail().equals(Applicant.getEmail()))
                .findFirst()
                .orElse(-1);
        if(ApplicantIndex == -1){
            return null;
        }
        ApplicantS.set(ApplicantIndex, Applicant);
        return Applicant;
    }

    public void deleteApplicant (UUID  id){
        var Applicant = findApplicantById(id);
        if(Applicant != null){
            ApplicantS.remove(Applicant);
        }
    }
}
