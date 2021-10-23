package dk.si.school.schoolgateway.client;

import dk.si.school.schoolgateway.RibbonConfig;
import dk.si.school.schoolgateway.model.Student;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@FeignClient("student-info")
@RibbonClient(name="student-info", configuration = RibbonConfig.class)
public interface StudentClient {
    @GetMapping("/students")
    Resources<Student> readStudent();
}

