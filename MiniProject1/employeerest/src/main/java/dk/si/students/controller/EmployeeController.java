package dk.si.students.controller;

import dk.si.students.exceptions.StudentNotFoundException;
import dk.si.students.model.Employee;
import dk.si.students.model.Student;
import dk.si.students.repository.EmployeeRepository;
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
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository repo;

    @GetMapping("/")
    public List<Employee> retrieveAllEmployees(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel<Employee> retrieveEmployee(@PathVariable long id)
    {
        Optional<Employee> employee = repo.findById(id);
        if (!employee.isPresent())
            throw new StudentNotFoundException("id: " + id);

        EntityModel<Employee> resource = EntityModel.of(employee.get()); 						// get the resource
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllEmployees()); // get link
        resource.add(linkTo.withRel("all-students"));										// append the link

        Link selfLink = linkTo(methodOn(this.getClass()).retrieveEmployee(id)).withSelfRel(); //add also link to self
        resource.add(selfLink);
        return resource;
    }
}
