package dk.si.students.controller;

import dk.si.students.model.Status;
import dk.si.students.model.Student;
import dk.si.students.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RepositoryRestResource
@ResponseBody
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentRepository repo;

    @GetMapping("/all")
    public List<Student> retrieveAllStudents()
    {
        return repo.findAll();
    }

    // This is the only method, which returns hyperlinks, for now
    // If the resource is found, a link to its 'family' is appended to its native load
    @GetMapping("/{id}")
    public Optional<Student> retrieveStudent(@PathVariable long id)
    {
        return repo.findById(id);
    }

    @GetMapping("/si/{status}")
    public List<Student> retrieveStudentWhoPassedCourse(@PathVariable Status status) throws Exception {
        List <Student> students = (List<Student>) repo.getStudentsBySi(status);
        if(students.isEmpty() || students == null){
            throw new Exception("No students passed SI");
        }
        return students;
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        repo.deleteById(id);
    }

    // Create a new resource and remember its unique location in the hypermedia
    @PostMapping("/")
    public ResponseEntity<Object> createStudent(@RequestBody Student student)
    {
        Student savedStudent = repo.save(student);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getSid()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id)
    {
        Optional<Student> studentOptional = repo.findById(id);
        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        student.setSid(id);
        repo.save(student);
        return ResponseEntity.noContent().build();
    }
}
