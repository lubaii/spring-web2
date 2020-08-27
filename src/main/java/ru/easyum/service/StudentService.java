package ru.easyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.easyum.domain.Student;
import ru.easyum.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student findStudent(int id){
        return repository.findById(id).get();
    }

    public List<Student> findAllStudents(){
        return StreamSupport.stream(repository.findAll().spliterator(),false).collect(Collectors.toList());
    }
    public void saveStudetn(Student student){
        repository.save(student);
    }
}
