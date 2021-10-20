package dk.si.students.repository;

import dk.si.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {
    // There are no methods here, but we can still use all those, which we inherit from JpaRepository
}
