package com.vaishnavi.practice.spring.boot.repository;

import com.vaishnavi.practice.spring.boot.model.SolarPanel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolarPanelRepository extends JpaRepository<SolarPanel, Long> {
}



