package pe.edu.upc.raze.consultancies.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.raze.consultancies.domain.model.entity.OutfitType;
import pe.edu.upc.raze.consultancies.resource.CreateOutfitTypeResource;
import pe.edu.upc.raze.consultancies.resource.OutfitTypeResource;
import pe.edu.upc.raze.consultancies.resource.UpdateOutfitTypeResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class OutfitTypeMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public OutfitTypeResource toResource(OutfitType model) {
        return mapper.map(model, OutfitTypeResource.class);
    }

    public Page<OutfitTypeResource> modelListToPage(List<OutfitType> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, OutfitTypeResource.class), pageable, modelList.size());
    }

    public OutfitType toModel(CreateOutfitTypeResource resource) {
        return mapper.map(resource, OutfitType.class);
    }

    public OutfitType toModel(UpdateOutfitTypeResource resource) {
        return mapper.map(resource, OutfitType.class);
    }

}
