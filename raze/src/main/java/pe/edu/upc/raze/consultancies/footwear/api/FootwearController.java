package pe.edu.upc.raze.consultancies.footwear.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.consultancies.footwear.domain.service.FootwearService;
import pe.edu.upc.raze.consultancies.footwear.mapping.FootwearMapper;
import pe.edu.upc.raze.consultancies.footwear.resource.CreateFootwearResource;
import pe.edu.upc.raze.consultancies.footwear.resource.FootwearResource;
import pe.edu.upc.raze.consultancies.footwear.resource.UpdateFootwearResource;


@RestController
@RequestMapping("/api/v1/footwear")
public class FootwearController {
    @Autowired
    private FootwearService footwearService;

    @Autowired
    private FootwearMapper mapper;

    @GetMapping
    public Page<FootwearResource> getAllFootwears(Pageable pageable) {
        return mapper.modelListToPage(footwearService.getAll() , pageable);
    }

    @GetMapping("{Id}")
    public FootwearResource getFootwearById(@PathVariable("Id") Long Id) {
        return mapper.toResource(footwearService.getById(Id));
    }

    @PostMapping
    public FootwearResource createFootwear(@RequestBody CreateFootwearResource request) {
        return mapper.toResource(footwearService.create(mapper.toModel(request)));
    }

    @PutMapping("{Id}")
    public FootwearResource updateFootwear(@PathVariable Long Id, @RequestBody UpdateFootwearResource request) {
        return mapper.toResource(footwearService.update(Id, mapper.toModel(request)));
    }

}
