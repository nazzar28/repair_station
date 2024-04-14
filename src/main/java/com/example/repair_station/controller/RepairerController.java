package com.example.repair_station.controller;

import com.example.repair_station.dto.repairer.RepairerRequest;
import com.example.repair_station.dto.repairer.RepairerResponse;
import com.example.repair_station.entities.Repairer;
import com.example.repair_station.service.interfaces.RepairerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/repairer")
public class RepairerController {
    private final RepairerService repairerService;

    @PostMapping("/register")
    public void register(@RequestBody RepairerRequest repairerRequest, @RequestHeader("Authorization") String token) {
        repairerService.register(repairerRequest,token);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable Long id) {
        repairerService.delete(id);
    }

    @PostMapping("/update")
    public void update(@PathVariable Long id, @RequestBody RepairerRequest repairerRequest){
        repairerService.update(id,repairerRequest);
    }

    @GetMapping("/find/{id}")
    public RepairerResponse find(@PathVariable Long id, @RequestHeader("Authorization") String token){
        return repairerService.find(id,token);
    }

    @GetMapping("/getAll")
    public List<RepairerResponse>repairerResponses(){
        return repairerService.getAll();
    }
}