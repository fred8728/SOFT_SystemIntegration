package dk.si.teachers.repository;

import dk.si.teachers.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
