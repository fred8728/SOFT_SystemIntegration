package dk.si.school.schoolgateway.client;

import dk.si.school.schoolgateway.RibbonConfig;
import dk.si.school.schoolgateway.model.Teacher;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.hateoas.Resources;

@CrossOrigin
@FeignClient("teacher")
@RibbonClient(name="teacher", configuration = RibbonConfig.class)
public interface TeacherClient
{
    @GetMapping("/teachers")
    Resources<Teacher> readTeacher();
}
