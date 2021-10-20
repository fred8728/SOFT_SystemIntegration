package dk.si.students.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_id;
    private String firstname;
    private String lastname;
    private String subject;

    public Employee() {
        super();
    }
}
