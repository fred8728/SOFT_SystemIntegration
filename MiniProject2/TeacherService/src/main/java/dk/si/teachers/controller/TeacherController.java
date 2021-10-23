package dk.si.teachers.controller;

import dk.si.teachers.model.Teacher;
import dk.si.teachers.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

//@RestController
@RepositoryRestResource
@ResponseBody
@RequestMapping("teachers")
public class TeacherController {
    @Autowired
    TeacherRepository repo;

    @GetMapping("/all")
    public List<Teacher> retrieveAllTeachers(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Teacher> retrieveTeacher(@PathVariable long id)
    {
        return repo.findById(id);
    }
}
