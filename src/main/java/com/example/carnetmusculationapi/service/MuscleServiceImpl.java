package com.example.carnetmusculationapi.service;

import com.example.carnetmusculationapi.dao.MuscleRepository;
import com.example.carnetmusculationapi.entity.Muscle;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MuscleServiceImpl implements MuscleService{

    private final MuscleRepository muscleRepository;

    @Override
    public List<Muscle> getAllMuscles() {
        List<Muscle> muscles = muscleRepository.findAll();

        if(muscles.size() > 0) {
            return muscles;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Muscle getMuscleByID(Long muscleID) throws RecordNotFoundException {
        Optional<Muscle> muscleOptional = muscleRepository.findById(muscleID);

        if(muscleOptional.isPresent()) {
            return muscleOptional.get();
        }else {
            throw new RecordNotFoundException("Aucun muscle existe pour cet ID");
        }
    }

    @Override
    public void deleteMuscleByID(Long muscleID) throws RecordNotFoundException {
        Optional<Muscle> muscleOptional = muscleRepository.findById(muscleID);

        if(muscleOptional.isPresent()) {
            muscleRepository.deleteById(muscleID);
        }else {
            throw new RecordNotFoundException("Aucun muscle existe pour cet ID");
        }

    }

    @Override
    public Muscle createOrUpdateMuscle(Muscle muscle) {
        Optional<Muscle> muscleOptional = muscleRepository.findById(muscle.getId());

        if(muscleOptional.isPresent()) {
            Muscle muscleNew = muscleOptional.get();
            muscleNew.setName(muscle.getName());

            muscleNew = muscleRepository.save(muscle);
            return muscleNew;
        } else {
            muscle = muscleRepository.save(muscle);
            return muscle;
        }
    }
}
