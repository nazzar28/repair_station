package com.example.repair_station.dto.repairer;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RepairerResponse {
    private Long id;
    private String name;
    private int age;
    private int cost_of_work;
    private String experience;
}