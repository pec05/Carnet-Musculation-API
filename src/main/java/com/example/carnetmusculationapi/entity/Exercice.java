package com.example.carnetmusculationapi.entity;

import com.example.carnetmusculationapi.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Exercices")
@Getter
@Setter
@ToString
public class Exercice extends BaseEntity {

    @Column(name = "name")
    @NotEmpty
    private String name;

    @ManyToOne
    @JoinColumn(name = "muscle_id")
    @NotEmpty
    private Muscle muscle;

    @NotEmpty
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "exercice", fetch = FetchType.EAGER)
    private List<Serie> series;

    @ManyToOne
    @JoinColumn(name = "workout_id")
    private Workout workout;
}
