package com.vaishnavi.practice.hibernate.service;

import com.vaishnavi.practice.hibernate.exception.DrawingNotFoundException;
import com.vaishnavi.practice.hibernate.model.Drawing;
import com.vaishnavi.practice.hibernate.repository.DrawingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrawingService {

    @Autowired
    private DrawingRepository drawingRepository;

    public Drawing createDrawing(Drawing drawing) {
        System.out.println("Inside service: " + drawing);
        return drawingRepository.save(drawing);
    }

    public Drawing deleteDrawing(int id) {
        Drawing deletedDrawing = drawingRepository.deleteById(id);
        System.out.println("Deleted drawing: " + deletedDrawing);
        return deletedDrawing;
    }

    public Drawing retrieveDrawing(int id) {
        Optional<Drawing> retrievedDrawing = drawingRepository.findById(id);
        if (retrievedDrawing.isEmpty()) {
            throw new DrawingNotFoundException("drawing not found");
        }
        System.out.println("retrievedDrawing : " + retrievedDrawing);
        return retrievedDrawing.get();
    }

    public List<Drawing> retrieveDrawings() {
        return drawingRepository.findAll();
    }
}


