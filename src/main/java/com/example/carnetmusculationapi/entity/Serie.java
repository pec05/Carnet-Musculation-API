package com.example.carnetmusculationapi.entity;

import com.example.carnetmusculationapi.model.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Series")
@Getter
@Setter
@ToString
public class Serie  extends BaseEntity {

    @Column(name = "num_Series")
    @NotEmpty
    private int numSeries;

    @Column(name = "repetition")
    @NotEmpty
    private int repetition;

    @Column(name = "weight")
    @NotEmpty
    private int weight;

    @ManyToOne
    @JoinColumn(name = "exercice_id")
    private Exercice exercice;
}
