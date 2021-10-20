package dk.si.school.schoolgateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dk.si.school.schoolgateway.client.ExamClient;
import dk.si.school.schoolgateway.model.Exam;
import dk.si.school.schoolgateway.model.Teacher;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ExamController {

    private ExamClient examClient = null;

    public ExamController(ExamClient examClient) {
        this.examClient = examClient;
    }

    @ResponseBody
    @CrossOrigin(origins = "*") // allow request from any client
    @HystrixCommand(fallbackMethod = "fallback") // in case of failure
    @GetMapping("/exams")
    public Collection<Exam> schoolExams()
    {
        return examClient.readExams()
                .getContent()
                .stream()
                .collect(Collectors.toList());
    }

    private Collection<Teacher> fallback()
    {
        return new ArrayList<>();
    }

}
