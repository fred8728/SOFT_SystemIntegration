package dk.si.students.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long sid;
    private String sname;
    private String smail;

    public Student() {
        super();
    }
}
