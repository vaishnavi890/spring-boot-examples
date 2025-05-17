package com.vaishnavi.filter.spring.boot.service;

import com.vaishnavi.filter.spring.boot.model.Artist;
import com.vaishnavi.filter.spring.boot.exceptions.ArtistNotFoundException;
import com.vaishnavi.filter.spring.boot.exceptions.NoArtistsInDatabaseException;
import com.vaishnavi.filter.spring.boot.repository.ArtistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private static final Logger logger = LoggerFactory.getLogger(ArtistService.class);

    @Autowired
    private ArtistRepository repo;

    public List<Artist> retrieveArtists() {
        logger.info("Inside ArtistService.retrieveArtists()");
        List<Artist> list = repo.retrieve();
        if (list == null || list.isEmpty())
            throw new NoArtistsInDatabaseException();
        return list;
    }

    public boolean storeArtist(Artist artist) {
        logger.info("Inside ArtistService.storeArtist()");
        return repo.store(artist);
    }

    public boolean deleteArtist(int id) {
        logger.info("Inside ArtistService.deleteArtist()");
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new ArtistNotFoundException();
        }
        return true;
    }

    public Artist searchArtist(int id) {
        logger.info("Inside ArtistService.searchArtist()");
        Artist artist = repo.search(id);
        if (artist == null)
            throw new ArtistNotFoundException();
        return artist;
    }
}



