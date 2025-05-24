package com.vaishnavi.practice.hibernate.repository;

import com.vaishnavi.practice.hibernate.config.HibernateConfig;
import com.vaishnavi.practice.hibernate.model.Drawing;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("drawingRepository")
public class DrawingRepositoryImpl implements DrawingRepository {

    private final SessionFactory sessionFactory;

    public DrawingRepositoryImpl() {
        sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Drawing save(Drawing drawing) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(drawing);
        session.getTransaction().commit();
        session.close();
        return drawing;
    }

    @Override
    public List<Drawing> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Drawing");
        List<Drawing> drawings = query.list();
        session.close();
        return drawings;
    }

    @Override
    public Optional<Drawing> findById(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Drawing where id = " + id);
        Drawing drawing = (Drawing) query.uniqueResult();
        if (drawing != null) {
            System.out.println("drawing: " + drawing.getTitle() + " | " + drawing.getArtist());
        }
        session.close();
        return Optional.ofNullable(drawing);
    }

    @Override
    public Drawing deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Drawing toBeDeletedDrawing = (Drawing) session.load(Drawing.class, id);
        session.delete(toBeDeletedDrawing);
        session.getTransaction().commit();
        session.flush();
        session.close();
        return toBeDeletedDrawing;
    }
}


