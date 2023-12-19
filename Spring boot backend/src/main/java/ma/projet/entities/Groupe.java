package ma.projet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String year;

    @ManyToMany(mappedBy = "groupes")
    private List<Student> students;

    @ManyToOne
    private Professor professor;

    @ManyToMany
    private List<PW> pwList;
}
