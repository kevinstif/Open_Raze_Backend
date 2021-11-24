package pe.edu.upc.raze.consultancies.top.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.raze.consultancies.top.domain.model.entity.TopModel;
import pe.edu.upc.raze.consultancies.top.resource.CreateTopResource;
import pe.edu.upc.raze.consultancies.top.resource.TopResource;
import pe.edu.upc.raze.consultancies.top.resource.UpdateTopResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;

import java.util.List;

public class TopMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public TopResource toResource(TopModel model){

        return mapper.map(model,TopResource.class);
    }

    public List<TopResource> modelListToPage (List<TopModel> modelList){
        return mapper.mapList(modelList, TopResource.class);
    }

    public TopModel toModel (CreateTopResource resource){

        return mapper.map(resource, TopModel.class);
    }

    public TopModel toModel (UpdateTopResource resource){

        return mapper.map( resource, TopModel.class);
    }


}
