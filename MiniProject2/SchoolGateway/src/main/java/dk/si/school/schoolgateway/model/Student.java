package dk.si.school.schoolgateway.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class Student {

    @NonNull private Long sid;
    @NonNull private String name;
    @NonNull private String email;
    @NonNull private Gender gender;
    @NonNull private Semester semester;
    @NonNull private Status si;
    @NonNull private Status test;
    @NonNull private Status dls;
}
