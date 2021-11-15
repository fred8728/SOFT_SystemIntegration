package si.bank.bankconsumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import si.bank.bankconsumer.model.Bank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Loan {

    private String loanId;
    private Bank bank;
    private double loan;
    private int termin;
    private double monthlyPayment;

}
