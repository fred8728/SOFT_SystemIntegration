package si.camunda.loan.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import si.camunda.loan.loan.model.ApplicantInfo;
import si.camunda.loan.loan.service.StartService;

@RestController
public class LoanController {

    @Autowired
    StartService startService;

    @PostMapping("send")
    public void sendApplication(@RequestBody ApplicantInfo info){
        startService.startProcessByLoanApplication(info);
    }
}
