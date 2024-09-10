package com.example.project2.service;

import com.example.project2.model.PrepodModel;
import com.example.project2.repository.PrepodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryPrepodImpl implements PrepodService {

    private final PrepodRepository PrepodRepository;

    public InMemoryPrepodImpl(PrepodRepository PrepodRepository){
        this.PrepodRepository = PrepodRepository;
    }

    @Override
    public List<PrepodModel> findAllPrepod() {
        return PrepodRepository.findAllPrepod();
    }

    @Override
    public PrepodModel createPrepod(PrepodModel Prepod) {
        return  PrepodRepository.createPrepod(Prepod);
    }

    @Override
    public PrepodModel updatePrepod(PrepodModel Prepod) {
        return  PrepodRepository.updatePrepod(Prepod);
    }

    @Override
    public PrepodModel findPrepodById(UUID id) {
        return PrepodRepository.findPrepodById(id);
    }

    @Override
    public void deletePrepod(UUID id) {
        PrepodRepository.deletePrepod(id);
    }
}
