package pe.edu.upc.raze.consultancies.bottom.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.consultancies.bottom.domain.service.BottomService;
import pe.edu.upc.raze.consultancies.bottom.mapping.BottomMapper;
import pe.edu.upc.raze.consultancies.bottom.resource.CreateBottomResource;
import pe.edu.upc.raze.consultancies.bottom.resource.BottomResource;
import pe.edu.upc.raze.consultancies.bottom.resource.UpdateBottomResource;

@RestController
@RequestMapping("/api/v1/bottom")
public class BottomController {

    @Autowired
    private BottomService bottomService;

    @Autowired
    private BottomMapper mapper;

    @GetMapping
    public Page<BottomResource> getAllFootwears(Pageable pageable) {
        return mapper.modelListToPage(bottomService.getAll() , pageable);
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
}