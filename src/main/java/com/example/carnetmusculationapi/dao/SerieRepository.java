package com.example.carnetmusculationapi.dao;

import com.example.carnetmusculationapi.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins ="http://localhost:4200")
@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
}
