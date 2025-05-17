package com.vaishnavi.filter.spring.boot.controller;

import com.vaishnavi.filter.spring.boot.model.Artwork;
import com.vaishnavi.filter.spring.boot.service.ArtworkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtworkController {

    private static final Logger logger = LoggerFactory.getLogger(ArtworkController.class);

    @Autowired
    private ArtworkService service;

    @GetMapping("/artworks")
    public ResponseEntity<List<Artwork>> getArtworks() {
        logger.info("GET /artworks called");
        return new ResponseEntity<>(service.retrieveArtworks(), HttpStatus.OK);
    }

    @PostMapping("/artworks")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> addArtwork(
            @RequestParam String title,
            @RequestParam String type,
            @RequestParam int artistId) {

        logger.info("POST /artworks called");
        Artwork artwork = new Artwork(title, type, artistId);
        return new ResponseEntity<>(service.storeArtwork(artwork) ? "Artwork added" : "Failed to add", HttpStatus.CREATED);
    }

    @DeleteMapping("/artworks/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> deleteArtwork(@PathVariable int id) {
        logger.info("DELETE /artworks/{id} called");
        return new ResponseEntity<>(service.deleteArtwork(id) ? "Artwork deleted" : "Failed to delete", HttpStatus.OK);
    }

    @GetMapping("/artworks/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> searchArtwork(@PathVariable int id) {
        logger.info("GET /artworks/{id} called");
        return new ResponseEntity<>(service.searchArtwork(id).toString(), HttpStatus.OK);
    }
}



