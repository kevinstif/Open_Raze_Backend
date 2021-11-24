package pe.edu.upc.raze.consultancies.bottom.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.raze.consultancies.bottom.domain.model.entity.BottomModel;
import pe.edu.upc.raze.consultancies.bottom.resource.BottomResource;
import pe.edu.upc.raze.consultancies.bottom.resource.CreateBottomResource;
import pe.edu.upc.raze.consultancies.bottom.resource.UpdateBottomResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class BottomMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public BottomResource toResource(BottomModel model){

        return mapper.map(model,BottomResource.class);
    }

    public List<BottomResource> modelListToPage (List<BottomModel> modelList){
        return mapper.mapList(modelList, BottomResource.class);
    }

    public BottomModel toModel (CreateBottomResource resource){
        return mapper.map(resource, BottomModel.class);
    }

    public BottomModel toModel (UpdateBottomResource resource){
        return mapper.map( resource, BottomModel.class);
    }

}
