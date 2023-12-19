package ma.projet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentPW {


    @EmbeddedId
    private StudentPWID id;

    private String time ;
    private String imageFront ;
    private Date date;

    @ManyToOne
    @MapsId("pwId")
    private PW pw;

    @ManyToOne
    @MapsId("studentId")
    private Student student;


}