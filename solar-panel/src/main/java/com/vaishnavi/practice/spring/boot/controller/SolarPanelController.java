package com.vaishnavi.practice.spring.boot.controller;

import com.vaishnavi.practice.spring.boot.model.SolarPanel;
import com.vaishnavi.practice.spring.boot.service.SolarPanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/panels")
public class SolarPanelController {

    @Autowired
    private SolarPanelService service;

    @PostMapping
    public SolarPanel createPanel(@RequestBody SolarPanel panel) {
        return service.savePanel(panel);
    }

    @GetMapping
    public List<SolarPanel> getAllPanels() {
        return service.getAllPanels();
    }

    @GetMapping("/{id}")
    public SolarPanel getPanelById(@PathVariable Long id) {
        return service.getPanelById(id).orElseThrow(() -> new RuntimeException("Panel not found"));
    }

    @PutMapping("/{id}")
    public SolarPanel updatePanel(@PathVariable Long id, @RequestBody SolarPanel panel) {
        return service.updatePanel(id, panel);
    }

    @DeleteMapping("/{id}")
    public String deletePanel(@PathVariable Long id) {
        service.deletePanel(id);
        return "Panel deleted successfully!";
    }
}



