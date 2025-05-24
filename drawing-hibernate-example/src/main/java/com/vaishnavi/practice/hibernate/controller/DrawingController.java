package com.vaishnavi.practice.hibernate.controller;

import com.vaishnavi.practice.hibernate.model.Drawing;
import com.vaishnavi.practice.hibernate.service.DrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drawingManagement")
public class DrawingController {

    @Autowired
    private DrawingService service;

    @PostMapping("/drawing")
    public ResponseEntity<Drawing> createDrawing(@RequestBody Drawing drawing) {
        System.out.println("Inside controller: " + drawing);
        return new ResponseEntity<>(service.createDrawing(drawing), HttpStatus.CREATED);
    }

    @DeleteMapping("/drawing/{id}")
    public ResponseEntity<Drawing> deleteDrawing(@PathVariable("id") int drawingId) {
        System.out.println("Inside controller: " + drawingId);
        return new ResponseEntity<>(service.deleteDrawing(drawingId), HttpStatus.OK);
    }

    @GetMapping("/drawing/{id}")
    public ResponseEntity<Drawing> retrieveDrawing(@PathVariable("id") int drawingId) {
        System.out.println("Inside controller: " + drawingId);
        return new ResponseEntity<>(service.retrieveDrawing(drawingId), HttpStatus.OK);
    }

    @GetMapping("/drawings")
    public List<Drawing> retrieveDrawings() {
        return service.retrieveDrawings();
    }
}


