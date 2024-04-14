package com.example.repair_station.repositories;

import com.example.repair_station.entities.Repairer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairerRepository extends JpaRepository<Repairer,Long> {
}
