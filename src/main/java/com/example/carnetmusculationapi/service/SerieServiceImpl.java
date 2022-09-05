package com.example.carnetmusculationapi.service;

import com.example.carnetmusculationapi.dao.SerieRepository;
import com.example.carnetmusculationapi.entity.Serie;
import com.example.carnetmusculationapi.exception.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SerieServiceImpl implements SerieService{

    private final SerieRepository serieRepository;

    @Override
    public List<Serie> getAllSeries() {
        List<Serie> series = serieRepository.findAll();

        if(series.size() > 0){
            return series;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Serie getSerieByID(Long serieID) throws RecordNotFoundException {
        Optional<Serie> serieOptional = serieRepository.findById(serieID);

        if(serieOptional.isPresent()){
            return serieOptional.get();
        } else {
            throw new RecordNotFoundException("Aucune serie existe pour cet ID");
        }
    }

    @Override
    public void deleteSerieByID(Long serieID) throws RecordNotFoundException {
        Optional<Serie> serieOptional = serieRepository.findById(serieID);

        if(serieOptional.isPresent()){
            serieRepository.deleteById(serieID);
        } else {
            throw new RecordNotFoundException("Aucune serie existe pour cet ID");
        }
    }

    @Override
    public Serie createOrUpdateSerie(Serie serie) {
        Optional<Serie> serieOptional = serieRepository.findById(serie.getId());

        if(serieOptional.isPresent()) {
            Serie serieNew = serieOptional.get();
            serieNew.setNumSeries(serie.getNumSeries());
            serieNew.setRepetition(serie.getRepetition());
            serieNew.setWeight(serie.getWeight());
            serieNew.setExercice(serie.getExercice());

            serieNew = serieRepository.save(serieNew);
            return serieNew;
        } else {
            serie = serieRepository.save(serie);
            return serie;
        }
    }
}
