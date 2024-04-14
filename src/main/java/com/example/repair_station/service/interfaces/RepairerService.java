package com.example.repair_station.service.interfaces;

import com.example.repair_station.dto.repairer.RepairerRequest;
import com.example.repair_station.dto.repairer.RepairerResponse;

import java.util.List;

public interface RepairerService {
    void register(RepairerRequest repairerRequest,String token);

    void delete(Long id);

    void update(Long id, RepairerRequest repairerRequest);

    RepairerResponse find(Long id,String token);

    List<RepairerResponse> getAll();
}
