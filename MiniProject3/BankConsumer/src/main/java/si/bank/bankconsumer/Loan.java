package si.bank.bankconsumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
