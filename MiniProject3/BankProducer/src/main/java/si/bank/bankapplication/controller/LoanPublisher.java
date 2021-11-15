package si.bank.bankapplication.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import si.bank.bankapplication.config.MQConfig;
import si.bank.bankapplication.model.Loan;

import java.util.UUID;

@RestController
public class LoanPublisher {

    si.bank.bankapplication.model.Loan Loan;

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publishLoan")
    public String publishLoan(@RequestBody Loan loan){
        loan.setLoanId(UUID.randomUUID().toString());
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, loan);
        return "Loan is published";
    }

    @PostMapping("/publishCustom")
    public String customLoan(@RequestBody Loan loan){
        loan.setLoanId(UUID.randomUUID().toString());
        double monthPayment = loan.calculateMonthlyPayment(loan.getBank(), loan.getLoan(), loan.getTermin());
        loan.setMonthlyPayment(monthPayment);
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, loan);
        return "CustomLoan is published";
    }
}
