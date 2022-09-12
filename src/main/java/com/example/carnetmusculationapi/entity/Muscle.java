package com.example.carnetmusculationapi.entity;

import com.example.carnetmusculationapi.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Muscles")
@Getter
@Setter
@ToString
public class Muscle extends BaseEntity {

    @Column(name = "name")
    @NotEmpty
    private String name;
}
