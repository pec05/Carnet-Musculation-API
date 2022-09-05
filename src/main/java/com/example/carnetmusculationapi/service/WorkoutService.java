package com.example.carnetmusculationapi.service;

import com.example.carnetmusculationapi.entity.Workout;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;

import java.util.List;

public interface WorkoutService {

    List<Workout> getAllWorkouts();

    Workout getWorkoutByID(Long workoutID) throws RecordNotFoundException;

    void deleteWorkoutByID(Long workoutID) throws RecordNotFoundException;

    Workout createOrUpdateSerie(Workout workout);
}
