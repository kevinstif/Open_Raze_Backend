package pe.edu.upc.raze.posts.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.raze.posts.domain.model.entity.Fashion;
import pe.edu.upc.raze.posts.resource.CreateFashionResource;
import pe.edu.upc.raze.posts.resource.FashionResource;
import pe.edu.upc.raze.posts.resource.UpdateFashionResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;
import java.util.List;

public class FashionMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public FashionResource toResource(Fashion model) {
        return mapper.map(model, FashionResource.class);
    }

    public List<FashionResource> modelListToPage(List<Fashion> modelList){
        return mapper.mapList(modelList, FashionResource.class);
    }

    public Fashion toModel(CreateFashionResource resource){
        return mapper.map(resource, Fashion.class);
    }

    public Fashion toModel(UpdateFashionResource resource){
        return mapper.map(resource, Fashion.class);
    }
}
