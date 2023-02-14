package pe.edu.upc.raze.users.interests.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.raze.users.interests.domain.model.entity.Interest;
import pe.edu.upc.raze.users.interests.resource.CreateInterestResource;
import pe.edu.upc.raze.users.interests.resource.InterestResource;
import pe.edu.upc.raze.users.interests.resource.UpdateInterestResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;
import java.util.List;

public class InterestMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public InterestResource toResource(Interest model) {
        return mapper.map(model, InterestResource.class);
    }

    public List<InterestResource> modelListToPage(List<Interest> modelList) {
        return mapper.mapList(modelList, InterestResource.class);
    }

    public Interest toModel(CreateInterestResource resource) {
        return mapper.map(resource, Interest.class);
    }

    public Interest toModel(UpdateInterestResource resource) {
        return mapper.map(resource, Interest.class);
    }
}
