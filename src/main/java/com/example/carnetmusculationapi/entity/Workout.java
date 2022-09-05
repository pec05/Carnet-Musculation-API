package com.example.carnetmusculationapi.entity;

import com.example.carnetmusculationapi.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Workouts")
@Getter
@Setter
@ToString
public class Workout extends BaseEntity {

    @NotEmpty
    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "workout", fetch = FetchType.EAGER)
    private List<Exercice> exercices;

    @Column(name = "details")
    private String details;
}
