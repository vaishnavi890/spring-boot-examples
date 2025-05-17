package com.vaishnavi.filter.spring.boot.service;

import com.vaishnavi.filter.spring.boot.model.Artwork;
import com.vaishnavi.filter.spring.boot.exceptions.ArtworkNotFoundException;
import com.vaishnavi.filter.spring.boot.exceptions.NoArtworksInDatabaseException;
import com.vaishnavi.filter.spring.boot.repository.ArtworkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtworkService {

    private static final Logger logger = LoggerFactory.getLogger(ArtworkService.class);

    @Autowired
    private ArtworkRepository repo;

    public List<Artwork> retrieveArtworks() {
        logger.info("Inside ArtworkService.retrieveArtworks()");
        List<Artwork> list = repo.retrieve();
        if (list == null || list.isEmpty())
            throw new NoArtworksInDatabaseException();
        return list;
    }

    public boolean storeArtwork(Artwork artwork) {
        logger.info("Inside ArtworkService.storeArtwork()");
        return repo.store(artwork);
    }

    public boolean deleteArtwork(int id) {
        logger.info("Inside ArtworkService.deleteArtwork()");
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new ArtworkNotFoundException();
        }
        return true;
    }

    public Artwork searchArtwork(int id) {
        logger.info("Inside ArtworkService.searchArtwork()");
        Artwork artwork = repo.search(id);
        if (artwork == null)
            throw new ArtworkNotFoundException();
        return artwork;
    }
}



