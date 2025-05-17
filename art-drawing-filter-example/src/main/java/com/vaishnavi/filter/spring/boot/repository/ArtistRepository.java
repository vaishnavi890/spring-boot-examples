package com.vaishnavi.filter.spring.boot.repository;

import com.vaishnavi.filter.spring.boot.model.Artist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArtistRepository implements EntityRepository<Artist> {

    private static final Logger logger = LoggerFactory.getLogger(ArtistRepository.class);
    private final List<Artist> artistList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Artist artist) {
        logger.info("Inside ArtistRepository.store()");
        artist.setId(++index);
        artistList.add(index, artist);
        return true;
    }

    @Override
    public List<Artist> retrieve() throws Exception {
        logger.info("Inside ArtistRepository.retrieve()");
        return artistList;
    }

    @Override
    public Artist search(int id) throws Exception {
        logger.info("Inside ArtistRepository.search()");
        return artistList.get(id);
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside ArtistRepository.delete()");
        artistList.remove(id);
        return true;
    }
}


