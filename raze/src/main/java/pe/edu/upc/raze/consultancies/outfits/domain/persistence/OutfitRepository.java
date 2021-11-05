package pe.edu.upc.raze.consultancies.outfits.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.raze.consultancies.outfits.domain.model.entity.Outfit;

@Repository
public interface OutfitRepository extends JpaRepository<Outfit,Long> {
}
