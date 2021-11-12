package pe.edu.upc.raze.users.customers.userAdvised.api;


import lombok.var;
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


        var userAdvisedsResource = userAdvisedMapper.modelListToPage(userAdvisedService.GetAll(),pageable);
        return userAdvisedsResource;
    }

    @GetMapping("{userAdvisedId}")
    public UserAdvisedResource GetUserAdvisedById(@PathVariable Long userAdvisedId){

        var userAdvisedResource = userAdvisedMapper.toResource(userAdvisedService.GetById(userAdvisedId));
        return userAdvisedResource;
    }

    @PostMapping
    public  UserAdvisedResource CreateUserAdvised(@RequestBody CreateUserAdvisedResource request){
        var userAdvised = userAdvisedMapper.toModel(request);

        var userAdvisedCreated = userAdvisedService.Create(userAdvised);

        var userAdvisedResource=userAdvisedMapper.toResource(userAdvisedCreated);

        return userAdvisedResource;
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