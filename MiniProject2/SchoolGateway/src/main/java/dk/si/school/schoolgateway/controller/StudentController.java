package dk.si.school.schoolgateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dk.si.school.schoolgateway.client.StudentClient;
import dk.si.school.schoolgateway.model.Student;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    private StudentClient studentClient = null;

    public StudentController(StudentClient studentClient) {
        this.studentClient = studentClient;
    }

    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client
    @HystrixCommand(fallbackMethod = "fallback") // in case of failure
    @GetMapping("/mystudents")
    public Collection<Student> schoolStudents()
    {
        return studentClient.readStudent()
                .getContent()
                .stream()
                .collect(Collectors.toList());
    }

    private Collection<Student> fallback()
    {
        return new ArrayList<>();
    }
}

