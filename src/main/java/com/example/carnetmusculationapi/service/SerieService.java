package com.example.carnetmusculationapi.service;

import com.example.carnetmusculationapi.entity.Serie;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;

import java.util.List;

public interface SerieService {

    List<Serie> getAllSeries();

    Serie getSerieByID(Long serieID) throws RecordNotFoundException;

    void deleteSerieByID(Long serieID) throws RecordNotFoundException;

    Serie createOrUpdateSerie(Serie serie);
}
