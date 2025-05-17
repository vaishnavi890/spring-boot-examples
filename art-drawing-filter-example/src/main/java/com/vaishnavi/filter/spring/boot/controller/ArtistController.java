package com.vaishnavi.filter.spring.boot.controller;

import com.vaishnavi.filter.spring.boot.model.Artist;
import com.vaishnavi.filter.spring.boot.service.ArtistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArtistController {

    private static final Logger logger = LoggerFactory.getLogger(ArtistController.class);

    @Autowired
    private ArtistService service;

    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getArtists() {
        logger.info("GET /artists called");
        return new ResponseEntity<>(service.retrieveArtists(), HttpStatus.OK);
    }

    @PostMapping("/artists")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> addArtist(
            @RequestParam String name,
            @RequestParam String style) {

        logger.info("POST /artists called");
        Artist artist = new Artist(name, style);
        return new ResponseEntity<>(service.storeArtist(artist) ? "Artist added" : "Failed to add", HttpStatus.CREATED);
    }

    @DeleteMapping("/artists/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> deleteArtist(@PathVariable int id) {
        logger.info("DELETE /artists/{id} called");
        return new ResponseEntity<>(service.deleteArtist(id) ? "Artist deleted" : "Failed to delete", HttpStatus.OK);
    }

    @GetMapping("/artists/{id}")
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<String> searchArtist(@PathVariable int id) {
        logger.info("GET /artists/{id} called");
        return new ResponseEntity<>(service.searchArtist(id).toString(), HttpStatus.OK);
    }
}



