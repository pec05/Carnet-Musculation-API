package com.example.carnetmusculationapi.controller;

import com.example.carnetmusculationapi.entity.Muscle;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;
import com.example.carnetmusculationapi.service.MuscleServiceImpl;
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
public class MucleController {

    private final MuscleServiceImpl muscleServiceImpl;

    @GetMapping("/muscles")
    private ResponseEntity<List<Muscle>> getAllMuscles() {
        List<Muscle> muscles = muscleServiceImpl.getAllMuscles();
        return new ResponseEntity<List<Muscle>>(muscles, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("muscle/{muscleID}")
    private ResponseEntity<Muscle> getMuscleByID(@PathVariable("muscleID") Long muscleID) throws RecordNotFoundException {
        Muscle muscle = muscleServiceImpl.getMuscleByID(muscleID);
        return new ResponseEntity<Muscle>(muscle,  new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/muscle/{muscleID}")
    private HttpStatus deleteMuscleByID(@PathVariable("muscleID") Long muscleID) throws RecordNotFoundException {
       muscleServiceImpl.deleteMuscleByID(muscleID);
        return HttpStatus.FORBIDDEN;
    }

    @PostMapping("/muscle")
    private ResponseEntity<Muscle> createOrUpdateMuscle(@RequestBody Muscle muscle) {
        Muscle muscleUpdated = muscleServiceImpl.createOrUpdateMuscle(muscle);
        return new ResponseEntity<Muscle>(muscleUpdated, new HttpHeaders(), HttpStatus.OK);
    }
}
