package ru.easyum.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.easyum.domain.Teacher;

import java.util.List;


public interface TeacherRepository extends PagingAndSortingRepository<Teacher,Integer> {
   // public List<Teacher>findAllByFio(String fio);

    @Query("Select t from Teacher t where t.about like %?1%" )
    public List<Teacher> findByAboutPartialMatch(String about);
}
