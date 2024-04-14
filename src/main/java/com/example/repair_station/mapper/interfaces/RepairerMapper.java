package com.example.repair_station.mapper.interfaces;

import com.example.repair_station.dto.repairer.RepairerResponse;
import com.example.repair_station.entities.Repairer;

import java.util.List;

public interface RepairerMapper {
    RepairerResponse toDto(Repairer repairer);

    List<RepairerResponse> toDtos(List<Repairer>all);
}
