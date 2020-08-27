package ru.easyum.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.easyum.domain.Student;

import java.util.List;


public interface StudentRepository extends PagingAndSortingRepository<Student,Integer> {
    public List<Student> findALLByFio(String fio);

    @Query("Select s from Student s where s.fio like %?1%" )
    public List<Student> findByAboutPartialMatch(String about);
}
