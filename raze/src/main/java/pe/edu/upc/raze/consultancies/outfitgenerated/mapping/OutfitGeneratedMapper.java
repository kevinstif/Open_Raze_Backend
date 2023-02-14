package pe.edu.upc.raze.consultancies.outfitgenerated.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.raze.consultancies.outfitgenerated.domain.model.entity.OutfitGeneratedModel;
import pe.edu.upc.raze.consultancies.outfitgenerated.resource.CreateOutfitGeneratedResource;
import pe.edu.upc.raze.consultancies.outfitgenerated.resource.OutfitGeneratedResource;
import pe.edu.upc.raze.consultancies.outfitgenerated.resource.UpdateOutfitGeneratedResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class OutfitGeneratedMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public OutfitGeneratedResource toResource(OutfitGeneratedModel model) {

        return mapper.map(model, OutfitGeneratedResource.class);
    }

    public List<OutfitGeneratedResource> modelListToPage(List<OutfitGeneratedModel> modelList) {
        return mapper.mapList(modelList, OutfitGeneratedResource.class);
    }

    public OutfitGeneratedModel toModel(CreateOutfitGeneratedResource resource) {
        return mapper.map(resource, OutfitGeneratedModel.class);
    }

    public OutfitGeneratedModel toModel(UpdateOutfitGeneratedResource resource) {
        return mapper.map(resource, OutfitGeneratedModel.class);
    }
}
