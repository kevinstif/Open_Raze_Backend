package pe.edu.upc.raze.consultancies.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.raze.consultancies.domain.model.entity.Outfit;
import pe.edu.upc.raze.consultancies.resource.CreateOutfitResource;
import pe.edu.upc.raze.consultancies.resource.OutfitResource;
import pe.edu.upc.raze.consultancies.resource.UpdateOutfitResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class OutfitMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public OutfitResource toResource(Outfit model) {
        return mapper.map(model, OutfitResource.class);
    }

    public Page<OutfitResource> modelListToPage(List<Outfit> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, OutfitResource.class), pageable, modelList.size());
    }

    public Outfit toModel(CreateOutfitResource resource) {
        return mapper.map(resource, Outfit.class);
    }

    public Outfit toModel(UpdateOutfitResource resource) {
        return mapper.map(resource, Outfit.class);
    }

}