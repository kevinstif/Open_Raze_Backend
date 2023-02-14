package pe.edu.upc.raze.users.professions.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;
import pe.edu.upc.raze.users.professions.domain.model.entity.ProfessionModel;
import pe.edu.upc.raze.users.professions.resource.CreateProfessionResource;
import pe.edu.upc.raze.users.professions.resource.ProfessionResource;
import pe.edu.upc.raze.users.professions.resource.UpdateProfessionResource;

import java.io.Serializable;
import java.util.List;

public class ProfessionMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    // Object Mapping
    public ProfessionResource toResource(ProfessionModel model) {
        return mapper.map(model, ProfessionResource.class);
    }

    public List<ProfessionResource> modelListToPage(List<ProfessionModel> modelList) {
        return mapper.mapList(modelList, ProfessionResource.class);
    }

    public ProfessionModel toModel(CreateProfessionResource resource) {
        return mapper.map(resource, ProfessionModel.class);
    }

    public ProfessionModel toModel(UpdateProfessionResource resource) {
        return mapper.map(resource, ProfessionModel.class);
    }

}
