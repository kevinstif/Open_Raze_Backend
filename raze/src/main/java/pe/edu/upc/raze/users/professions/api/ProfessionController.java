package pe.edu.upc.raze.users.professions.api;

import org.springframework.http.ResponseEntity;
import pe.edu.upc.raze.users.professions.domain.service.ProfessionService;
import pe.edu.upc.raze.users.professions.mapping.ProfessionMapper;
import pe.edu.upc.raze.users.professions.resource.CreateProfessionResource;
import pe.edu.upc.raze.users.professions.resource.ProfessionResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.users.professions.resource.UpdateProfessionResource;

import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/v1/professions")
public class ProfessionController {
    @Autowired
    private ProfessionService professionService;

    @Autowired
    private ProfessionMapper mapper;

    @GetMapping
    public List<ProfessionResource> getAllProfessions() {
        return mapper.modelListToPage(professionService.getAll());
    }

    @GetMapping("{Id}")
    public ProfessionResource getProfessionById(@PathVariable("Id") Long Id) {
        return mapper.toResource(professionService.getById(Id));
    }

    @PostMapping
    public ProfessionResource createProfession(@RequestBody CreateProfessionResource request) {
        return mapper.toResource(professionService.create(mapper.toModel(request)));
    }

    @PutMapping("{Id}")
    public ProfessionResource updateProfession(@PathVariable Long Id, @RequestBody UpdateProfessionResource request) {
        return mapper.toResource(professionService.update(Id, mapper.toModel(request)));
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<?> deletePost(@PathVariable Long Id) {
        return professionService.delete(Id);
    }

}
