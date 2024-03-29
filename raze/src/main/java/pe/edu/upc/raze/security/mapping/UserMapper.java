package pe.edu.upc.raze.security.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.raze.security.domain.model.entity.User;
import pe.edu.upc.raze.security.domain.service.communication.RegisterRequest;
import pe.edu.upc.raze.security.resource.UpdateUserResource;
import pe.edu.upc.raze.security.resource.UserResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public UserResource toResource(User model) {
        return mapper.map(model, UserResource.class);
    }

    public List<UserResource> modelListToPage(List<User> modelList) {
        return mapper.mapList(modelList, UserResource.class);
    }

    public User toModel(RegisterRequest resource) {
        return mapper.map(resource, User.class);
    }

    public User toModel(UpdateUserResource resource) {
        return mapper.map(resource, User.class);
    }

}
