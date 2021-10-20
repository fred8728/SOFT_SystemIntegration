package dk.si.students.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @NonNull private Long sid;
    @NonNull private String name;
    @NonNull private String email;
    @NonNull private Gender gender;
    @NonNull private Semester semester;
    @NonNull private Status si;
    @NonNull private Status test;
    @NonNull private Status dls;

}
