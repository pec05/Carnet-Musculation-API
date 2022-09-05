package com.example.carnetmusculationapi.service;

import com.example.carnetmusculationapi.dao.ExerciceRepository;
import com.example.carnetmusculationapi.entity.Exercice;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
//@EnableSwagger2
public class ExerciceServiceImpl implements ExerciceService{

    private final ExerciceRepository exerciceRepository;

    @Override
    public List<Exercice> getAllExercices() {
        List<Exercice> exercices = exerciceRepository.findAll();

        if(exercices.size() > 0) {
            return exercices;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Exercice getExerciceByID(Long exerciseID) throws RecordNotFoundException {
        Optional<Exercice> exerciceOptional = exerciceRepository.findById(exerciseID);

        if(exerciceOptional.isPresent()) {
            return exerciceOptional.get();
        } else {
            throw new RecordNotFoundException("Aucun exercice existe pour cet ID");
        }
    }

    @Override
    public void deleteExerciceByID(Long exerciseID) throws RecordNotFoundException {
        Optional<Exercice> exerciceOptional = exerciceRepository.findById(exerciseID);

        if(exerciceOptional.isPresent()) {
            exerciceRepository.deleteById(exerciseID);
        } else {
            throw new RecordNotFoundException("Aucun exercice existe pour cet ID");
        }
    }

    @Override
    public Exercice createOrUpdateExercice(Exercice exercice) {
        Optional<Exercice> exerciceOptional = exerciceRepository.findById(exercice.getId());

        if(exerciceOptional.isPresent()) {
            Exercice exerciceNew = exerciceOptional.get();
            exerciceNew.setName(exercice.getName());
            exerciceNew.setMuscle(exercice.getMuscle());
            exerciceNew.setSeries(exercice.getSeries());
            exerciceNew.setWorkout(exercice.getWorkout());

            exerciceNew = exerciceRepository.save(exerciceNew);
            return exerciceNew;
        } else {
            exercice = exerciceRepository.save(exercice);
            return exercice;
        }
    }
}
