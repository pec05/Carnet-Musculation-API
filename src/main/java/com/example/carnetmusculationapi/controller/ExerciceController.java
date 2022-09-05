package com.example.carnetmusculationapi.controller;

import com.example.carnetmusculationapi.entity.Exercice;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;
import com.example.carnetmusculationapi.service.ExerciceServiceImpl;
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
public class ExerciceController {

    private final ExerciceServiceImpl exerciceServiceImpl;

    @GetMapping("/exercices")
    private ResponseEntity<List<Exercice>>getAllExercices() {
        List<Exercice> exercices = exerciceServiceImpl.getAllExercices();
        return new ResponseEntity<List<Exercice>>(exercices, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("exercice/{exerciceID}")
    private ResponseEntity<Exercice> getExerciceByID(@PathVariable("exerciceID") Long exerciceID) throws RecordNotFoundException {
        Exercice exercice = exerciceServiceImpl.getExerciceByID(exerciceID);
        return new ResponseEntity<Exercice>(exercice,  new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/exercice/{exerciceID}")
    private HttpStatus deleteExerciceByID(@PathVariable("exerciceID") Long exerciceID) throws RecordNotFoundException {
        exerciceServiceImpl.deleteExerciceByID(exerciceID);
        return HttpStatus.FORBIDDEN;
    }

    @PostMapping("/exercice")
    private ResponseEntity<Exercice> createOrUpdateExercice(@RequestBody Exercice exercice) {
        Exercice exerciceUpdated = exerciceServiceImpl.createOrUpdateExercice(exercice);
        return new ResponseEntity<Exercice>(exerciceUpdated, new HttpHeaders(), HttpStatus.OK);
    }
}
