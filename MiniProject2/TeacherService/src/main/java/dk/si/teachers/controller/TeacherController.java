package dk.si.teachers.controller;

import dk.si.teachers.exceptions.TeacherNotFoundException;
import dk.si.teachers.model.Teacher;
import dk.si.teachers.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    TeacherRepository repo;

    @GetMapping("/")
    public List<Teacher> retrieveAllTeachers(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel<Teacher> retrieveTeacher(@PathVariable long id)
    {
        Optional<Teacher> teacher = repo.findById(id);
        if (!teacher.isPresent())
            throw new TeacherNotFoundException("The given teacher id: " + id);

        EntityModel<Teacher> resource = EntityModel.of(teacher.get()); 						// get the resource
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllTeachers()); // get link
        resource.add(linkTo.withRel("all-teachers"));										// append the link

        Link selfLink = linkTo(methodOn(this.getClass()).retrieveTeacher(id)).withSelfRel(); //add also link to self
        resource.add(selfLink);
        return resource;
    }
}
