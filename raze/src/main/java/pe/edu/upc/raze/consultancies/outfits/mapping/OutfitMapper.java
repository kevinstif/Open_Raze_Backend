package pe.edu.upc.raze.consultancies.outfits.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.raze.consultancies.outfits.domain.model.entity.Outfit;
import pe.edu.upc.raze.consultancies.outfits.resource.CreateOutfitResource;
import pe.edu.upc.raze.consultancies.outfits.resource.OutfitResource;
import pe.edu.upc.raze.consultancies.outfits.resource.UpdateOutfitResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class OutfitMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public OutfitResource toResource(Outfit model) {
        return mapper.map(model, OutfitResource.class);
    }

    public List<OutfitResource> modelListToPage(List<Outfit> modelList) {
        return mapper.mapList(modelList, OutfitResource.class);
    }

    public Outfit toModel(CreateOutfitResource resource) {
        return mapper.map(resource, Outfit.class);
    }

    public Outfit toModel(UpdateOutfitResource resource) {
        return mapper.map(resource, Outfit.class);
    }

}
