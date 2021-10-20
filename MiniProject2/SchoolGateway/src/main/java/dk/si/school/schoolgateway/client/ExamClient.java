package dk.si.school.schoolgateway.client;

import dk.si.school.schoolgateway.RibbonConfig;
import dk.si.school.schoolgateway.model.Exam;
import dk.si.school.schoolgateway.model.Teacher;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@FeignClient("exam-info")
@RibbonClient(name="exam-info", configuration = RibbonConfig.class)
public interface ExamClient {
    @GetMapping("/exams")
    Resources<Exam> readExams();
}
