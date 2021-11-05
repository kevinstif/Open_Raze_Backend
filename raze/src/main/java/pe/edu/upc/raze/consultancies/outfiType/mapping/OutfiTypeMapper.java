package pe.edu.upc.raze.consultancies.outfiType.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.raze.consultancies.outfiType.domain.model.entity.OutfiType;
import pe.edu.upc.raze.consultancies.outfiType.resource.CreateOutfiTypeResource;
import pe.edu.upc.raze.consultancies.outfiType.resource.OutfiTypeResource;
import pe.edu.upc.raze.consultancies.outfiType.resource.UpdateOutfiTypeResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class OutfiTypeMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public OutfiTypeResource toResource(OutfiType model) {
        return mapper.map(model, OutfiTypeResource.class);
    }

    public Page<OutfiTypeResource> modelListToPage(List<OutfiType> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, OutfiTypeResource.class), pageable, modelList.size());
    }

    public OutfiType toModel(CreateOutfiTypeResource resource) {
        return mapper.map(resource, OutfiType.class);
    }

    public OutfiType toModel(UpdateOutfiTypeResource resource) {
        return mapper.map(resource, OutfiType.class);
    }

}
