package pe.edu.upc.raze.users.customers.userAdvisors.mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;
import pe.edu.upc.raze.users.customers.userAdvisors.domain.model.entity.UserAdvisor;
import pe.edu.upc.raze.users.customers.userAdvisors.resources.CreateUserAdvisorResource;
import pe.edu.upc.raze.users.customers.userAdvisors.resources.UpdateUserAdvisorResource;
import pe.edu.upc.raze.users.customers.userAdvisors.resources.UserAdvisorResource;

import java.io.Serializable;
import java.util.List;

@Configuration("UserAdvisorConfiguration")
public class UserAdvisorMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public UserAdvisorResource toResource(UserAdvisor model) {
        return mapper.map(model, UserAdvisorResource.class);
    }

    public Page<UserAdvisorResource> modelListToPage(List<UserAdvisor> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserAdvisorResource.class), pageable, modelList.size());
    }

    public UserAdvisor toModel(CreateUserAdvisorResource resource) {
        return mapper.map(resource, UserAdvisor.class);
    }

    public UserAdvisor toModel(UpdateUserAdvisorResource resource) {
        return mapper.map(resource, UserAdvisor.class);
    }
}