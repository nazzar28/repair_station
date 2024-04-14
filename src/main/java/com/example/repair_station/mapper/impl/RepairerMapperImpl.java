package com.example.repair_station.mapper.impl;

import com.example.repair_station.dto.repairer.RepairerResponse;
import com.example.repair_station.entities.Repairer;
import com.example.repair_station.mapper.interfaces.RepairerMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepairerMapperImpl implements RepairerMapper {
    @Override
    public RepairerResponse toDto(Repairer repairer){
        RepairerResponse repairerResponse=new RepairerResponse();
        repairerResponse.setId(repairer.getId());
        repairerResponse.setName(repairer.getName());
        repairerResponse.setAge(repairer.getAge());
        repairerResponse.setExperience(repairer.getExperience());
        return repairerResponse;
    }

    @Override
    public List<RepairerResponse> toDtos(List<Repairer>all){
        List<RepairerResponse>repairerResponses=new ArrayList<>();
        for(Repairer repairer:all){
            repairerResponses.add(toDto(repairer));
        }
        return repairerResponses;
    }
}
