package pe.edu.upc.raze.consultancies.footwear.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.raze.consultancies.footwear.domain.model.entity.FootwearModel;
import pe.edu.upc.raze.consultancies.footwear.resource.CreateFootwearResource;
import pe.edu.upc.raze.consultancies.footwear.resource.FootwearResource;
import pe.edu.upc.raze.consultancies.footwear.resource.UpdateFootwearResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class FootwearMapper implements Serializable {
   @Autowired
    EnhancedModelMapper mapper;

    public FootwearResource toResource(FootwearModel model){

        return mapper.map(model,FootwearResource.class);
    }

    public Page<FootwearResource> modelListToPage (List<FootwearModel> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, FootwearResource.class), pageable, modelList.size());
    }

    public FootwearModel toModel (CreateFootwearResource resource){

        return mapper.map(resource, FootwearModel.class);
    }

    public FootwearModel toModel (UpdateFootwearResource resource){
        return mapper.map( resource, FootwearModel.class);
    }


}
