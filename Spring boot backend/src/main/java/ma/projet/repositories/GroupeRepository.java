package ma.projet.repositories;

import ma.projet.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeRepository extends JpaRepository<Groupe,Long> {
}
