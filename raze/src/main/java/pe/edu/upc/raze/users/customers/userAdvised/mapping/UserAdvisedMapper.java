package pe.edu.upc.raze.users.customers.userAdvised.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;
import pe.edu.upc.raze.users.customers.userAdvised.domain.model.entity.UserAdvised;
import pe.edu.upc.raze.users.customers.userAdvised.resources.CreateUserAdvisedResource;
import pe.edu.upc.raze.users.customers.userAdvised.resources.UpdateUserAdvisedResource;
import pe.edu.upc.raze.users.customers.userAdvised.resources.UserAdvisedResource;

import java.io.Serializable;
import java.util.List;

public class UserAdvisedMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public UserAdvisedResource toResource(UserAdvised model) {
        return mapper.map(model, UserAdvisedResource.class);
    }

    public Page<UserAdvisedResource> modelListToPage(List<UserAdvised> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserAdvisedResource.class), pageable, modelList.size());
    }

    public UserAdvised toModel(CreateUserAdvisedResource resource) {
        return mapper.map(resource, UserAdvised.class);
    }

    public UserAdvised toModel(UpdateUserAdvisedResource resource) {
        return mapper.map(resource, UserAdvised.class);
    }

}
