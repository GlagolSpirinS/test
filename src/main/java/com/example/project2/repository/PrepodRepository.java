package com.example.project2.repository;

import com.example.project2.model.PrepodModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;


@Repository
public class PrepodRepository {
    private final List<PrepodModel> PrepodS = new ArrayList<>();

    public List<PrepodModel> findAllPrepod(){
        return PrepodS;
    }

    public PrepodModel findPrepodById(UUID id) {
        return PrepodS.stream()
                .filter(element -> element.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public PrepodModel createPrepod(PrepodModel Prepod){
        PrepodS.add(Prepod);
        return Prepod;
    }

    public PrepodModel updatePrepod(PrepodModel Prepod){
        var PrepodIndex = IntStream.range(0, PrepodS.size())
                .filter(index-> PrepodS.get(index).getEmail().equals(Prepod.getEmail()))
                .findFirst()
                .orElse(-1);
        if(PrepodIndex == -1){
            return null;
        }
        PrepodS.set(PrepodIndex, Prepod);
        return Prepod;
    }

    public void deletePrepod (UUID  id){
        var Prepod = findPrepodById(id);
        if(Prepod != null){
            PrepodS.remove(Prepod);
        }
    }
}
