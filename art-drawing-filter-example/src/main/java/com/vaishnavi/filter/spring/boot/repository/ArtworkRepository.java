package com.vaishnavi.filter.spring.boot.repository;

import com.vaishnavi.filter.spring.boot.model.Artwork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ArtworkRepository implements EntityRepository<Artwork> {

    private static final Logger logger = LoggerFactory.getLogger(ArtworkRepository.class);
    private final List<Artwork> artworkList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Artwork artwork) {
        logger.info("Inside ArtworkRepository.store()");
        artwork.setId(++index);
        artworkList.add(index, artwork);
        return true;
    }

    @Override
    public List<Artwork> retrieve() throws Exception {
        logger.info("Inside ArtworkRepository.retrieve()");
        return artworkList;
    }

    @Override
    public Artwork search(int id) throws Exception {
        logger.info("Inside ArtworkRepository.search()");
        return artworkList.get(id);
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside ArtworkRepository.delete()");
        artworkList.remove(id);
        return true;
    }
}



