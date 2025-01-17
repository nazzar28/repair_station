package com.example.repair_station.entities;

import com.example.repair_station.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="cars_table")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int age;
    private String number;
    @Enumerated(EnumType.STRING)
    private Type model;

    @ManyToOne
    Repairer repairer;

    @ManyToOne
    Customer customer;
}
