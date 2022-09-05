package com.example.carnetmusculationapi.service;

import com.example.carnetmusculationapi.dao.WorkoutRepository;
import com.example.carnetmusculationapi.entity.Workout;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService{

    private final WorkoutRepository workoutRepository;

    @Override
    public List<Workout> getAllWorkouts() {
        List<Workout> workouts = workoutRepository.findAll();

        if(workouts.size() > 0) {
            return workouts;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Workout getWorkoutByID(Long workoutID) throws RecordNotFoundException {
        Optional<Workout> workoutOptional = workoutRepository.findById(workoutID);

        if(workoutOptional.isPresent()) {
            return workoutOptional.get();
        } else {
            throw new RecordNotFoundException("Aucun entrainement existe pour cet ID");
        }
    }

    @Override
    public void deleteWorkoutByID(Long workoutID) throws RecordNotFoundException {
        Optional<Workout> workoutOptional = workoutRepository.findById(workoutID);

        if(workoutOptional.isPresent()) {
            workoutRepository.deleteById(workoutID);
        } else {
            throw new RecordNotFoundException("Aucun entrainement existe pour cet ID");
        }
    }

    @Override
    public Workout createOrUpdateSerie(Workout workout) {
        Optional<Workout> workoutOptional = workoutRepository.findById(workout.getId());

        if(workoutOptional.isPresent()) {
            Workout workoutNew = workoutOptional.get();
            workoutNew.setName(workout.getName());
            workoutNew.setDate(workout.getDate());
            workoutNew.setExercices(workout.getExercices());
            workoutNew.setDetails(workout.getDetails());

            workoutNew = workoutRepository.save(workoutNew);
            return workoutNew;
        } else {
            workout = workoutRepository.save(workout);
            return workout;
        }
    }
}
