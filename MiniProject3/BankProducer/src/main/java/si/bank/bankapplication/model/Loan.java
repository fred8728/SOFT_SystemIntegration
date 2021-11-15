package si.bank.bankapplication.model;

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

    public static double calculateMonthlyPayment(Bank bank, double loan, int termin)
    {
        double rate = 0;
        if (bank == Bank.NORDEA){
            rate = 4.1;
        } else if (bank == Bank.DANSKEBANK){
            rate = 4.2;
        }else if (bank == Bank.JYSKEBANK){
            rate = 5.0;
        }else if (bank == Bank.SYDBANK){
            rate = 3.3;
        }

        double monthlyRate = (rate/100.0) / 12;
        int termsInMonths = termin * 12;
        double monthlyPayment = (monthlyRate * loan)/(1-Math.pow((1+monthlyRate), -termsInMonths));
        return monthlyPayment;
    }

    public static void main(String[] args) {
        double nordea = calculateMonthlyPayment(Bank.NORDEA, 25000.00, 2);
        double jyske= calculateMonthlyPayment(Bank.JYSKEBANK, 25000.00, 2);
        double danske = calculateMonthlyPayment(Bank.DANSKEBANK, 25000.00, 2);
        double sydbank = calculateMonthlyPayment(Bank.SYDBANK, 25000.00, 2);
        System.out.println(nordea);
        System.out.println(jyske);
        System.out.println(danske);
        System.out.println(sydbank);
    }
}
