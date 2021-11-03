package pe.edu.upc.raze.users.interests.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.users.interests.domain.service.InterestService;
import pe.edu.upc.raze.users.interests.mapping.InterestMapper;
import pe.edu.upc.raze.users.interests.resource.CreateInterestResource;
import pe.edu.upc.raze.users.interests.resource.InterestResource;
import pe.edu.upc.raze.users.interests.resource.UpdateInterestResource;

@RestController
@RequestMapping("/api/v1/interests")
public class InterestController {

    @Autowired
    private InterestService interestService;

    @Autowired
    private InterestMapper mapper;

    @GetMapping
    public Page<InterestResource> getAllInterests(Pageable pageable){
        return mapper.modelListToPage(interestService.getAll(), pageable);
    }

    @GetMapping("{interestId}")
    public InterestResource getInterestById(@PathVariable("interestId") Long interestId) {
        return mapper.toResource(interestService.getById(interestId));
    }

    @PostMapping
    public InterestResource createInterest(@RequestBody CreateInterestResource request){
        return mapper.toResource(interestService.create(mapper.toModel(request)));
    }

    @PutMapping("{interestId}")
    public InterestResource updateInterest(@PathVariable Long interestId, @RequestBody UpdateInterestResource request){
        return mapper.toResource(interestService.update(interestId, mapper.toModel(request)));
    }

    @DeleteMapping("{interestId}")
    public ResponseEntity<?> deletePost(@PathVariable Long interestId){
        return interestService.delete(interestId);
    }
}
