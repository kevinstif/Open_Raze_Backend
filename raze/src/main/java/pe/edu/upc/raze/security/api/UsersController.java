package pe.edu.upc.raze.security.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.security.domain.service.UserService;
import pe.edu.upc.raze.security.domain.service.communication.RegisterRequest;
import pe.edu.upc.raze.security.mapping.UserMapper;
import pe.edu.upc.raze.security.resource.UpdateUserResource;
import pe.edu.upc.raze.security.resource.UserResource;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    @GetMapping
    public List<UserResource> GetAllUser() {
        return mapper.modelListToPage(userService.getAll());
    }

    @GetMapping("{userId}")
    public UserResource GetUserAdvisedById(@PathVariable Long userId) {
        return mapper.toResource(userService.getById(userId));
    }

    @PostMapping
    public UserResource CreateUser(@RequestBody RegisterRequest request) {
        return mapper.toResource(
                userService.register(mapper.toModel(request), request.getInterestId(), request.getProfessionId()));
    }

    @PutMapping("{userId}")
    public UserResource updateUser(@PathVariable Long userId, @RequestBody UpdateUserResource request) {
        return mapper.toResource(userService.update(userId, mapper.toModel(request)));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        return userService.delete(userId);
    }
}
