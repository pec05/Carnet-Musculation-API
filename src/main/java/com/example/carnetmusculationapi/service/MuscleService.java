package com.example.carnetmusculationapi.service;

import com.example.carnetmusculationapi.entity.Muscle;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;

import java.util.List;

public interface MuscleService {

    List<Muscle> getAllMuscles();

    Muscle getMuscleByID(Long muscleID) throws RecordNotFoundException;

    void deleteMuscleByID(Long muscleID) throws RecordNotFoundException;

    Muscle createOrUpdateMuscle(Muscle muscle);
}
