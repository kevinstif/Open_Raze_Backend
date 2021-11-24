package pe.edu.upc.raze.consultancies.outfitgenerated.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.raze.consultancies.outfitgenerated.domain.model.entity.OutfitGeneratedModel;

public interface OutfitGeneratedRepository  extends JpaRepository<OutfitGeneratedModel, Long>  {
}
