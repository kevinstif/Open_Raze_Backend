package pe.edu.upc.raze.consultancies.bottom.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.consultancies.bottom.domain.service.BottomService;
import pe.edu.upc.raze.consultancies.bottom.mapping.BottomMapper;
import pe.edu.upc.raze.consultancies.bottom.resource.CreateBottomResource;
import pe.edu.upc.raze.consultancies.bottom.resource.BottomResource;
import pe.edu.upc.raze.consultancies.bottom.resource.UpdateBottomResource;

import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/v1/bottom")
public class BottomController {

    @Autowired
    private BottomService bottomService;

    @Autowired
    private BottomMapper mapper;

    @GetMapping
    public List<BottomResource> getAllFootwears() {
        return mapper.modelListToPage(bottomService.getAll());
    }

    @GetMapping("{Id}")
    public BottomResource getFootwearById(@PathVariable("Id") Long Id) {
        return mapper.toResource(bottomService.getById(Id));
    }

    @PostMapping
    public BottomResource createFootwear(@RequestBody CreateBottomResource request) {
        return mapper.toResource(bottomService.create(mapper.toModel(request)));
    }

    @PutMapping("{Id}")
    public BottomResource updateFootwear(@PathVariable Long Id, @RequestBody UpdateBottomResource request) {
        return mapper.toResource(bottomService.update(Id, mapper.toModel(request)));
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<?> deleteBottom(@PathVariable Long Id){
        return bottomService.delete(Id) ;
    }
}
