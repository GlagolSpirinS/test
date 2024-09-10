package com.example.project2.service;

import com.example.project2.model.PrepodModel;

import java.util.List;
import java.util.UUID;

public interface PrepodService {
    List<PrepodModel> findAllPrepod();
    PrepodModel createPrepod(PrepodModel Prepod);
    PrepodModel updatePrepod(PrepodModel Prepod);
    PrepodModel findPrepodById(UUID id);
    void deletePrepod(UUID id);
}
