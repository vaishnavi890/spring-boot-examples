package com.vaishnavi.filter.spring.boot.controller;

import com.vaishnavi.filter.spring.boot.model.Gallery;
import com.vaishnavi.filter.spring.boot.service.GalleryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GalleryController {

    private static final Logger logger = LoggerFactory.getLogger(GalleryController.class);

    @Autowired
    private GalleryService service;

    @GetMapping("/galleries")
    public ResponseEntity<List<Gallery>> getGalleries() {
        logger.info("GET /galleries called");
        return new ResponseEntity<>(service.retrieveGalleries(), HttpStatus.OK);
    }

    @PostMapping("/galleries")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> addGallery(
            @RequestParam String name,
            @RequestParam String location) {

        logger.info("POST /galleries called");
        Gallery gallery = new Gallery(name, location);
        return new ResponseEntity<>(service.storeGallery(gallery) ? "Gallery added" : "Failed to add", HttpStatus.CREATED);
    }

    @DeleteMapping("/galleries/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> deleteGallery(@PathVariable int id) {
        logger.info("DELETE /galleries/{id} called");
        return new ResponseEntity<>(service.deleteGallery(id) ? "Gallery deleted" : "Failed to delete", HttpStatus.OK);
    }

    @GetMapping("/galleries/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> searchGallery(@PathVariable int id) {
        logger.info("GET /galleries/{id} called");
        return new ResponseEntity<>(service.searchGallery(id).toString(), HttpStatus.OK);
    }
}


