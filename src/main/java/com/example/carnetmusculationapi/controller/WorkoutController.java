package com.example.carnetmusculationapi.controller;

import com.example.carnetmusculationapi.entity.Workout;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;
import com.example.carnetmusculationapi.service.WorkoutServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping(path = "/api")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutServiceImpl workoutServiceImpl;

    @GetMapping("/workouts")
    private ResponseEntity<List<Workout>> getAllWorkouts() {
        List<Workout> workouts = workoutServiceImpl.getAllWorkouts();
        return new ResponseEntity<List<Workout>>(workouts, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("workout/{workoutID}")
    private ResponseEntity<Workout> getWorkoutByID(@PathVariable("workoutID") Long workoutID) throws RecordNotFoundException {
        Workout workout = workoutServiceImpl.getWorkoutByID(workoutID);
        return new ResponseEntity<Workout>(workout,  new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/workout/{workoutID}")
    private HttpStatus deleteWorkoutByID(@PathVariable("workoutID") Long workoutID) throws RecordNotFoundException {
        workoutServiceImpl.deleteWorkoutByID(workoutID);
        return HttpStatus.FORBIDDEN;
    }

    @PostMapping("/workout")
    private ResponseEntity<Workout> createOrUpdateWorkout(@RequestBody Workout workout) {
        Workout workoutUpdated = workoutServiceImpl.createOrUpdateSerie(workout);
        return new ResponseEntity<Workout>(workoutUpdated, new HttpHeaders(), HttpStatus.OK);
    }
}
