package com.vaishnavi.practice.spring.boot.service;

import com.vaishnavi.practice.spring.boot.model.SolarPanel;
import com.vaishnavi.practice.spring.boot.repository.SolarPanelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolarPanelService {

    @Autowired
    private SolarPanelRepository repository;

    public SolarPanel savePanel(SolarPanel panel) {
        return repository.save(panel);
    }

    public List<SolarPanel> getAllPanels() {
        return repository.findAll();
    }

    public Optional<SolarPanel> getPanelById(Long id) {
        return repository.findById(id);
    }

    public SolarPanel updatePanel(Long id, SolarPanel panelDetails) {
        SolarPanel panel = repository.findById(id).orElseThrow(() -> new RuntimeException("Panel not found"));
        panel.setPanelName(panelDetails.getPanelName());
        panel.setLocation(panelDetails.getLocation());
        panel.setCapacity(panelDetails.getCapacity());
        panel.setStatus(panelDetails.getStatus());
        return repository.save(panel);
    }

    public void deletePanel(Long id) {
        repository.deleteById(id);
    }
}


