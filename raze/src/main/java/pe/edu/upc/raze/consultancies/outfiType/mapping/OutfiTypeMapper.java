package pe.edu.upc.raze.consultancies.outfiType.mapping;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<OutfiTypeResource> modelListToPage(List<OutfiType> modelList) {
        return mapper.mapList(modelList, OutfiTypeResource.class);
    }

    public OutfiType toModel(CreateOutfiTypeResource resource) {
        return mapper.map(resource, OutfiType.class);
    }

    public OutfiType toModel(UpdateOutfiTypeResource resource) {
        return mapper.map(resource, OutfiType.class);
    }

}
