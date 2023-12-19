package ma.projet.repositories;

import ma.projet.entities.Tooth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToothRepository extends JpaRepository<Tooth,Long> {
}
