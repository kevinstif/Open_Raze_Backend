package pe.edu.upc.raze.users.customers.userAdvisors.api;

import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.users.customers.userAdvisors.domain.services.UserAdvisorService;
import pe.edu.upc.raze.users.customers.userAdvisors.mapping.UserAdvisorMapper;
import pe.edu.upc.raze.users.customers.userAdvisors.resources.CreateUserAdvisorResource;
import pe.edu.upc.raze.users.customers.userAdvisors.resources.UpdateUserAdvisorResource;
import pe.edu.upc.raze.users.customers.userAdvisors.resources.UserAdvisorResource;

@RestController
@RequestMapping("/api/v1/useradvisors")
public class UserAdvisorsController {
    private final UserAdvisorService userAdvisorService;
    private final UserAdvisorMapper userAdvisorMapper;

    public UserAdvisorsController(UserAdvisorService userAdvisorService, UserAdvisorMapper userAdvisorMapper) {
        this.userAdvisorService = userAdvisorService;
        this.userAdvisorMapper = userAdvisorMapper;
    }

    @GetMapping
    public Page<UserAdvisorResource> GetAllUserAdvisors(Pageable pageable){


        var userAdvisorsResource = userAdvisorMapper.modelListToPage(userAdvisorService.GetAll(),pageable);
        return userAdvisorsResource;
    }

    @GetMapping("{userAdvisorId}")
    public UserAdvisorResource GetUserAdvisorById(@PathVariable Long userAdvisorId){

        var userAdvisorResource = userAdvisorMapper.toResource(userAdvisorService.GetById(userAdvisorId));
        return userAdvisorResource;
    }

    @PostMapping
    public  UserAdvisorResource CreateUserAdvisor(@RequestBody CreateUserAdvisorResource request){
        var userAdvisor = userAdvisorMapper.toModel(request);

        var userAdvisorCreated = userAdvisorService.Create(userAdvisor);

        var userAdvisorResource=userAdvisorMapper.toResource(userAdvisorCreated);

        return userAdvisorResource;
    }

    @PutMapping("{userAdvisorId}")
    public UserAdvisorResource updateUserAdvisor(@PathVariable Long userAdvisorId, @RequestBody UpdateUserAdvisorResource request){
        return userAdvisorMapper.toResource(userAdvisorService.Update(userAdvisorId,userAdvisorMapper.toModel(request)));
    }

    @DeleteMapping("{userAdvisorId}")
    public ResponseEntity<?> deleteUserAdvisor(@PathVariable Long userAdvisorId){
        return userAdvisorService.Delete(userAdvisorId);
    }
}