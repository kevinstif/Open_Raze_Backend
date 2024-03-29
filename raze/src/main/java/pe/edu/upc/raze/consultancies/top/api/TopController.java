package pe.edu.upc.raze.consultancies.top.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.consultancies.top.domain.service.TopService;
import pe.edu.upc.raze.consultancies.top.mapping.TopMapper;
import pe.edu.upc.raze.consultancies.top.resource.CreateTopResource;
import pe.edu.upc.raze.consultancies.top.resource.TopResource;
import pe.edu.upc.raze.consultancies.top.resource.UpdateTopResource;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RestController
@RequestMapping("/api/v1/top")
public class TopController {
    @Autowired
    private TopService topService;

    @Autowired
    private TopMapper mapper;

    @GetMapping
    public List<TopResource> getAllTops() {
        return mapper.modelListToPage(topService.getAll());
    }

    @GetMapping("{Id}")
    public TopResource getTopById(@PathVariable("Id") Long Id) {
        return mapper.toResource(topService.getById(Id));
    }

    @PostMapping
    public TopResource createTop(@RequestBody CreateTopResource request) {
        return mapper.toResource(topService.create(mapper.toModel(request)));
    }

    @PutMapping("{Id}")
    public TopResource updateTop(@PathVariable Long Id, @RequestBody UpdateTopResource request) {
        return mapper.toResource(topService.update(Id, mapper.toModel(request)));
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<?> deleteTop(@PathVariable Long Id) {
        return topService.delete(Id);
    }

}
