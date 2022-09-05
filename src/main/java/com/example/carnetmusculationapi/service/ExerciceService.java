package com.example.carnetmusculationapi.service;

import com.example.carnetmusculationapi.entity.Exercice;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;

import java.util.List;

public interface ExerciceService {

    List<Exercice> getAllExercices();

    Exercice getExerciceByID(Long exerciseID) throws RecordNotFoundException;

    void deleteExerciceByID(Long exerciseID) throws RecordNotFoundException;

    Exercice createOrUpdateExercice(Exercice exercice);
}
