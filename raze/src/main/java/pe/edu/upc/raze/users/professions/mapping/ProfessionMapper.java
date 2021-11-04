package pe.edu.upc.raze.users.professions.mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public Page<ProfessionResource> modelListToPage(List<ProfessionModel> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ProfessionResource.class), pageable, modelList.size());
    }

    public ProfessionModel toModel(CreateProfessionResource resource) { return mapper.map(resource, ProfessionModel.class); }

    public ProfessionModel toModel(UpdateProfessionResource resource) { return mapper.map(resource, ProfessionModel.class); }

}
