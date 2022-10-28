package com.example.reusebook.Service;

import com.example.reusebook.Model.Student;
import com.example.reusebook.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<Student> addStudent(Student student){
        Student s = studentRepository.save(student);
        return  new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    public ResponseEntity<Student> updateStudent(long studentId, Student studentR) {
        Student student = studentRepository.findById(studentId).orElseThrow();
        student.setName(studentR.getName());
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.OK);
    }

    public ResponseEntity<HttpStatus> deleteStudent(long id) {
        studentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
