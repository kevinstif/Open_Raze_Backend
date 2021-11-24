package pe.edu.upc.raze.consultancies.outfitgenerated.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public OutfitGeneratedResource toResource(OutfitGeneratedModel model){

        return mapper.map(model,OutfitGeneratedResource.class);
    }

    public Page<OutfitGeneratedResource> modelListToPage (List<OutfitGeneratedModel> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, OutfitGeneratedResource.class), pageable, modelList.size());
    }

    public OutfitGeneratedModel toModel (CreateOutfitGeneratedResource resource){
        return mapper.map(resource, OutfitGeneratedModel.class);
    }

    public OutfitGeneratedModel toModel (UpdateOutfitGeneratedResource resource){
        return mapper.map( resource, OutfitGeneratedModel.class);
    }
}
