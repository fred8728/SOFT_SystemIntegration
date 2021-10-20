package dk.rest.examservice.repository;

import dk.rest.examservice.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
