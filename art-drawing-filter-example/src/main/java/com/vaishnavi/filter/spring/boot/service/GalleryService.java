package com.vaishnavi.filter.spring.boot.service;

import com.vaishnavi.filter.spring.boot.model.Gallery;
import com.vaishnavi.filter.spring.boot.exceptions.GalleryNotFoundException;
import com.vaishnavi.filter.spring.boot.exceptions.NoGalleriesInDatabaseException;
import com.vaishnavi.filter.spring.boot.repository.GalleryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService {

    private static final Logger logger = LoggerFactory.getLogger(GalleryService.class);

    @Autowired
    private GalleryRepository repo;

    public List<Gallery> retrieveGalleries() {
        logger.info("Inside GalleryService.retrieveGalleries()");
        List<Gallery> list = repo.retrieve();
        if (list == null || list.isEmpty())
            throw new NoGalleriesInDatabaseException();
        return list;
    }

    public boolean storeGallery(Gallery gallery) {
        logger.info("Inside GalleryService.storeGallery()");
        return repo.store(gallery);
    }

    public boolean deleteGallery(int id) {
        logger.info("Inside GalleryService.deleteGallery()");
        try {
            repo.delete(id);
        } catch (Exception e) {
            throw new GalleryNotFoundException();
        }
        return true;
    }

    public Gallery searchGallery(int id) {
        logger.info("Inside GalleryService.searchGallery()");
        Gallery gallery = repo.search(id);
        if (gallery == null)
            throw new GalleryNotFoundException();
        return gallery;
    }
}



