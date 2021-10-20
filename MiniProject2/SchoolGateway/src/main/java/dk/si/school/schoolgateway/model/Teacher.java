package dk.si.school.schoolgateway.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Teacher {
    @NonNull private Long sid;
    @NonNull private String firstname;
    @NonNull private String lastname;
    @NonNull private Course course;
}
