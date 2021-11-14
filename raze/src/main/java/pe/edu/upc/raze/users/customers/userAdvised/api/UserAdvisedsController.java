package pe.edu.upc.raze.users.customers.userAdvised.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.users.customers.userAdvised.domain.services.UserAdvisedService;
import pe.edu.upc.raze.users.customers.userAdvised.mapping.UserAdvisedMapper;
import pe.edu.upc.raze.users.customers.userAdvised.resources.CreateUserAdvisedResource;
import pe.edu.upc.raze.users.customers.userAdvised.resources.UpdateUserAdvisedResource;
import pe.edu.upc.raze.users.customers.userAdvised.resources.UserAdvisedResource;

@RestController
@RequestMapping("/api/v1/useradviseds")
public class UserAdvisedsController 
{
    private final UserAdvisedService userAdvisedService;
    private final UserAdvisedMapper userAdvisedMapper;

    public UserAdvisedsController(UserAdvisedService userAdvisedService, UserAdvisedMapper userAdvisedMapper) {
        this.userAdvisedService = userAdvisedService;
        this.userAdvisedMapper = userAdvisedMapper;
    }

    @GetMapping
    public Page<UserAdvisedResource> GetAllUserAdviseds(Pageable pageable){
        return userAdvisedMapper.modelListToPage(userAdvisedService.GetAll(),pageable);
    }

    @GetMapping("{userAdvisedId}")
    public UserAdvisedResource GetUserAdvisedById(@PathVariable Long userAdvisedId){
        return userAdvisedMapper.toResource(userAdvisedService.GetById(userAdvisedId));
    }

    @PostMapping
    public  UserAdvisedResource CreateUserAdvised(@RequestBody CreateUserAdvisedResource request){
        var userAdvised = userAdvisedMapper.toModel(request);
        var userAdvisedCreated = userAdvisedService.Create(userAdvised);
        return userAdvisedMapper.toResource(userAdvisedCreated);
    }

    @PutMapping("{userAdvisedId}")
    public UserAdvisedResource updateUserAdvised(@PathVariable Long userAdvisedId, @RequestBody UpdateUserAdvisedResource request){
        return userAdvisedMapper.toResource(userAdvisedService.Update(userAdvisedId,userAdvisedMapper.toModel(request)));
    }

    @DeleteMapping("{userAdvisedId}")
    public ResponseEntity<?> deleteUserAdvised(@PathVariable Long userAdvisedId){
        return userAdvisedService.Delete(userAdvisedId);
    }
}