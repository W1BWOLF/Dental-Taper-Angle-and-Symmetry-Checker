package ma.projet.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class StudentPWID implements Serializable {
    private Long pwId;
    private Long studentId;
}
