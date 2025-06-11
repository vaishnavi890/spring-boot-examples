package com.vaishnavi.spring.boot.hibernate.repository;

import com.vaishnavi.spring.boot.hibernate.config.HibernateConfig;
import com.vaishnavi.spring.boot.hibernate.exception.StudentNotFoundException;
import com.vaishnavi.spring.boot.hibernate.model.Clazz;
import com.vaishnavi.spring.boot.hibernate.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {

    private final SessionFactory sessionFactory;

    public StudentRepositoryImpl() {
        sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Student save(Student student) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();

        return student;
    }

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student");
        return query.list();
    }

    @Override
    public Optional<Student> findById(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student where id =" + id);
        Student student = (Student) query.uniqueResult();
        System.out.println("student:" + student.getName() + "|" + student.getPercentage());
        return Optional.ofNullable(student);
    }

    @Override
    public Student deleteById(int id) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Student tobeDeletedStudent = (Student) session.load(Student.class, id);
        if (tobeDeletedStudent != null) {
            session.delete(tobeDeletedStudent);
        } else {
            throw new StudentNotFoundException("Student not found for id:" + id);
        }
        session.getTransaction().commit();
        session.flush();
        session.close();
        return tobeDeletedStudent;
    }

    @Override
    public List<Student> findStudentWithPagination(int page, int size) {
        Session session = sessionFactory.openSession();
        return session.createQuery("from student")
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .list();
    }
}

