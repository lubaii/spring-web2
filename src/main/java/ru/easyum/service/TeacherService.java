package ru.easyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.easyum.domain.Course;
import ru.easyum.domain.Teacher;
import ru.easyum.repository.TeacherRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public Teacher findTeacher(int id){
        return repository.findById(id).get();
    }

    public List<Teacher> findAllTeachers(){
        return StreamSupport.stream(repository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    public List<Teacher> findTeacherByAbout(String about){

        return repository.findByAboutPartialMatch(about);
    }

    public void saveTeacher(Teacher teacher){
        repository.save(teacher);}

    /*public List<Teacher> findTeacherByFio(String fio){
        return repository.findAllBy(fio);
    }*/

    public List<Teacher> getPage(Integer pageNo, Integer pageSize){
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Teacher> pageCourses = repository.findAll(paging);
        if(pageCourses.hasContent()) {
            return pageCourses.getContent();
        } else {
            return Collections.EMPTY_LIST;
        }
    }

}
