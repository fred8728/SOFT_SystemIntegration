package dk.si.school.schoolgateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dk.si.school.schoolgateway.client.TeacherClient;
import dk.si.school.schoolgateway.model.Teacher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class TeacherController {
    private TeacherClient teacherClient = null;

    public TeacherController(TeacherClient teacherClient) {
        this.teacherClient = teacherClient;
    }

    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client
    @HystrixCommand(fallbackMethod = "fallback") // in case of failure
    @GetMapping("/myteachers")
    public Collection<Teacher> schoolTeachers()
    {
        return teacherClient.readTeacher()
                .getContent()
                .stream()
                .collect(Collectors.toList());
    }

    private Collection<Teacher> fallback()
    {
        return new ArrayList<>();
    }
}
