package dk.rest.examservice.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private Course course;
    private ExamType examtype;
    private Date examdate;

    public Exam() {
        super();
    }
}
