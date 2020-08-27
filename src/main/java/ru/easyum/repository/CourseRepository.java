package ru.easyum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.easyum.domain.Course;
import ru.easyum.domain.Teacher;

import java.util.List;


public interface CourseRepository extends PagingAndSortingRepository<Course, Integer> {
    public List<Course> findALLByName(String name);

    @Query("Select c from Course c where c.name like %?1%" )
    List<Course> findByAboutPartialMatch(String name);
}
