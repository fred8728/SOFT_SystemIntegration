package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Result {

    @Id
    private String studentId;
    private String semester;
    private String billedekunst;
    private String geografi;
    private String haendarbejde;

}