package com.example.carnetmusculationapi.controller;

import com.example.carnetmusculationapi.entity.Serie;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;
import com.example.carnetmusculationapi.service.SerieServiceImpl;
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
public class SerieController {

    private final SerieServiceImpl serieServiceImpl;

    @GetMapping("/series")
    private ResponseEntity<List<Serie>> getAllSeries() {
        List<Serie> series = serieServiceImpl.getAllSeries();
        return new ResponseEntity<List<Serie>>(series, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("serie/{serieID}")
    private ResponseEntity<Serie> getSerieByID(@PathVariable("serieID") Long serieID) throws RecordNotFoundException {
        Serie serie = serieServiceImpl.getSerieByID(serieID);
        return new ResponseEntity<Serie>(serie,  new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/serie/{serieID}")
    private HttpStatus deleteSerieByID(@PathVariable("serieID") Long serieID) throws RecordNotFoundException {
        serieServiceImpl.deleteSerieByID(serieID);
        return HttpStatus.FORBIDDEN;
    }

    @PostMapping("/serie")
    private ResponseEntity<Serie> createOrUpdateSerie(@RequestBody Serie serie) {
        Serie serieUpdated = serieServiceImpl.createOrUpdateSerie(serie);
        return new ResponseEntity<Serie>(serieUpdated, new HttpHeaders(), HttpStatus.OK);
    }
}
