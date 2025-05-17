package com.vaishnavi.filter.spring.boot.repository;

import com.vaishnavi.filter.spring.boot.model.Gallery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GalleryRepository implements EntityRepository<Gallery> {

    private static final Logger logger = LoggerFactory.getLogger(GalleryRepository.class);
    private final List<Gallery> galleryList = new ArrayList<>();
    private int index = -1;

    @Override
    public boolean store(Gallery gallery) {
        logger.info("Inside GalleryRepository.store()");
        gallery.setId(++index);
        galleryList.add(index, gallery);
        return true;
    }

    @Override
    public List<Gallery> retrieve() throws Exception {
        logger.info("Inside GalleryRepository.retrieve()");
        return galleryList;
    }

    @Override
    public Gallery search(int id) throws Exception {
        logger.info("Inside GalleryRepository.search()");
        return galleryList.get(id);
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Inside GalleryRepository.delete()");
        galleryList.remove(id);
        return true;
    }
}



