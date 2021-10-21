package dk.si.students.repository;

import dk.si.students.model.Status;
import dk.si.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {
    //Student findStudentsBySi_PassedEquals();
    List<Student> getStudentsBySi(Status status);

}
