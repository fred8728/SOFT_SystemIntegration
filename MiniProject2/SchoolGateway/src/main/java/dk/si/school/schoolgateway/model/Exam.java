package dk.si.school.schoolgateway.model;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class Exam {

    @NonNull private int sid;
    @NonNull private Course course;
    @NonNull private ExamType examtype;
    @NonNull private Date examdate;
}
