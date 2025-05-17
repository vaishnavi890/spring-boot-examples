package com.vaishnavi.filter.spring.boot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Artwork Exceptions
    @ExceptionHandler(ArtworkNotFoundException.class)
    public ResponseEntity<Object> handleArtworkNotFound(ArtworkNotFoundException ex) {
        return new ResponseEntity<>("Artwork not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoArtworksInDatabaseException.class)
    public ResponseEntity<Object> handleNoArtworks(NoArtworksInDatabaseException ex) {
        return new ResponseEntity<>("No artworks in the database", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArtworkNotFoundToDeleteException.class)
    public ResponseEntity<Object> handleArtworkDelete(ArtworkNotFoundToDeleteException ex) {
        return new ResponseEntity<>("Artwork not found to delete", HttpStatus.NOT_FOUND);
    }

    // Artist Exceptions
    @ExceptionHandler(ArtistNotFoundException.class)
    public ResponseEntity<Object> handleArtistNotFound(ArtistNotFoundException ex) {
        return new ResponseEntity<>("Artist not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoArtistsInDatabaseException.class)
    public ResponseEntity<Object> handleNoArtists(NoArtistsInDatabaseException ex) {
        return new ResponseEntity<>("No artists in the database", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArtistNotFoundToDeleteException.class)
    public ResponseEntity<Object> handleArtistDelete(ArtistNotFoundToDeleteException ex) {
        return new ResponseEntity<>("Artist not found to delete", HttpStatus.NOT_FOUND);
    }

    // Gallery Exceptions
    @ExceptionHandler(GalleryNotFoundException.class)
    public ResponseEntity<Object> handleGalleryNotFound(GalleryNotFoundException ex) {
        return new ResponseEntity<>("Gallery not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoGalleriesInDatabaseException.class)
    public ResponseEntity<Object> handleNoGalleries(NoGalleriesInDatabaseException ex) {
        return new ResponseEntity<>("No galleries in the database", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GalleryNotFoundToDeleteException.class)
    public ResponseEntity<Object> handleGalleryDelete(GalleryNotFoundToDeleteException ex) {
        return new ResponseEntity<>("Gallery not found to delete", HttpStatus.NOT_FOUND);
    }
}


