package si.camunda.loan.loan.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApplicantInfo {

    private String name;
    private int income;
    private String bank;
    private int amount;
    private int termin;
    private String type;
    private String monthlyPayment;
}
