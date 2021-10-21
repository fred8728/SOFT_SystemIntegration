package dk.si.school.schoolgateway.controller;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dk.si.school.schoolgateway.client.TeacherClient;
import dk.si.school.schoolgateway.model.Teacher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class TeacherController {
    private TeacherClient teacherClient = null;

    public TeacherController(TeacherClient teacherClient) {
        this.teacherClient = teacherClient;
    }


    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client
    @HystrixCommand(fallbackMethod = "fallback") // in case of failure
    @GetMapping("/teachers")
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
