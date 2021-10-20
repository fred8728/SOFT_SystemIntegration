package dk.rest.examservice.controller;

import dk.rest.examservice.exceptions.ExamNotFoundException;
import dk.rest.examservice.model.Exam;
import dk.rest.examservice.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
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
    public EntityModel<Exam> retrieveExam(@PathVariable int id)
    {
        Optional<Exam> exam = repo.findById(id);
        if(!exam.isPresent()){
            throw new ExamNotFoundException("The given exam id: " + id);
        }
        EntityModel<Exam> resource = EntityModel.of(exam.get());
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllExams());
        resource.add(linkTo.withRel("all-exams"));

        Link selfLink = linkTo(methodOn(this.getClass()).retrieveExam(id)).withSelfRel();
        resource.add(selfLink);
        return resource;
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
