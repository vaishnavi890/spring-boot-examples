package com.vaishnavi.practice.spring.boot.service;



import com.vaishnavi.practice.spring.boot.model.Student;
import com.vaishnavi.practice.spring.boot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> studentData = studentRepository.findById(id);

        if (studentData.isPresent()) {
            Student student = studentData.get();
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setRoomNumber(studentDetails.getRoomNumber());
            return studentRepository.save(student);
        } else {
            return null;
        }
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }
}



