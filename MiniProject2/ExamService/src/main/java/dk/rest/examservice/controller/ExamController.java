package dk.rest.examservice.controller;

import dk.rest.examservice.model.Exam;
import dk.rest.examservice.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

//@RestController
@RepositoryRestResource
@ResponseBody
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    ExamRepository repo;

    @GetMapping("/all")
    public List<Exam> retrieveAllExams()
    {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Exam> retrieveExam(@PathVariable int id)
    {
        return repo.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable int id) {
        repo.deleteById(id);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createExam(@RequestBody Exam exam)
    {
        Exam savedExam = repo.save(exam);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedExam.getSid()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateExam(@RequestBody Exam exam, @PathVariable int id)
    {
        Optional<Exam> studentOptional = repo.findById(id);
        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        exam.setSid(id);
        repo.save(exam);
        return ResponseEntity.noContent().build();
    }
}
