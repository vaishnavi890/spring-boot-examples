package com.vaishnavi.practice.hibernate.service;

import com.vaishnavi.practice.hibernate.exception.StudentNotFoundException;
import com.vaishnavi.practice.hibernate.model.Student;
import com.vaishnavi.practice.hibernate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        System.out.println("Inside service: " + student);
        return studentRepository.save(student);
    }

    public Student deleteStudent(int id) {
        Student deletedStudent = studentRepository.deleteById(id);
        System.out.println("Deleted student: " + deletedStudent);
        return deletedStudent;
    }

    public Student retrieveStudent(int id) {
        Optional<Student> retrievedStudent = studentRepository.findById(id);
        if (retrievedStudent.isEmpty()) {
            throw new StudentNotFoundException("student not found");
        }
        System.out.println("retrievedStudent : " + retrievedStudent);
        return retrievedStudent.get();
    }

    public List<Student> retrieveStudents() {
        return studentRepository.findAll();
    }
}

