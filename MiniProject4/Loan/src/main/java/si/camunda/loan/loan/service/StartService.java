package si.camunda.loan.loan.service;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import si.camunda.loan.loan.model.ApplicantInfo;

@Service
public class StartService {

    @Autowired
    RuntimeService runtimeService;

    public void startProcessByLoanApplication(ApplicantInfo info){
        runtimeService.createMessageCorrelation("application")
                .setVariable("name", info.getName())
                .setVariable("income", info.getIncome())
                .setVariable("bank", info.getBank())
                .setVariable("amount", info.getAmount())
                .setVariable("termin", info.getTermin())
                .setVariable("job", info.getType())
                .setVariable("monthlypayment", monthlyPayment(info.getAmount(), info.getTermin()))
                .correlate();
    }

    public int monthlyPayment(int amount, int termin)
    {
        int rate = 0;
        if(amount<25000){
            rate = 2;
        } else if (amount>25000){
            rate =1;
        }

        int monthlyRate = (int) ((rate/100) / 12);
        int termsInMonths = termin * 12;
        int monthlyPayment = (int) ((monthlyRate * amount)/(1-Math.pow((1+monthlyRate), -termsInMonths)));
        return monthlyPayment;
    }
}
