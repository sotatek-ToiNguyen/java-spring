package interview.me.spring.repository;

import interview.me.spring.model.entity.Student;
import interview.me.spring.model.enums.SubjectEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findFirstById(long id);

    List<Student> findAll();

    List<Student> findAllByFirstName(String name);

    @Query(
            value =
                    "SELECT S from Student S " +
                            "join Teacher T on S.teacherId = T.id where S.firstName LIKE CONCAT('%', :name, '%') " +
                            "AND ((:teacherName IS NOT NULL AND T.name = :teacherName) OR (:subject IS NOT NULL AND T.subject = :subject))")
    List<Student> findAllByNameAndTeacher(String name, String teacherName, SubjectEnum subject);

    @Query(
            value =
                    "SELECT S from Student S " +
                            "join Teacher T on S.teacherId = T.id where " +
                            "((:teacherName IS NOT NULL AND T.name = :teacherName) OR (:subject IS NOT NULL AND T.subject = :subject))")
    List<Student> findAllByTeacher(String teacherName, SubjectEnum subject);
}
