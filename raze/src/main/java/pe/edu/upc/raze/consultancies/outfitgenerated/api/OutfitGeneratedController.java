package pe.edu.upc.raze.consultancies.outfitgenerated.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.consultancies.outfitgenerated.domain.service.OutfitGeneratedService;
import pe.edu.upc.raze.consultancies.outfitgenerated.mapping.OutfitGeneratedMapper;
import pe.edu.upc.raze.consultancies.outfitgenerated.resource.CreateOutfitGeneratedResource;
import pe.edu.upc.raze.consultancies.outfitgenerated.resource.OutfitGeneratedResource;
import pe.edu.upc.raze.consultancies.outfitgenerated.resource.UpdateOutfitGeneratedResource;

import java.util.List;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
@RestController
@RequestMapping("/api/v1/outfitgenerated")
public class OutfitGeneratedController {

    @Autowired
    private OutfitGeneratedService outfitgeneratedService;

    @Autowired
    private OutfitGeneratedMapper mapper;

    @GetMapping
    public List<OutfitGeneratedResource> getAllOutfitGenerated() {
        return mapper.modelListToPage(outfitgeneratedService.getAll());
    }

    @GetMapping("{Id}")
    public OutfitGeneratedResource getOutfitGeneratedById(@PathVariable("Id") Long Id) {
        return mapper.toResource(outfitgeneratedService.getById(Id));
    }

    @PostMapping
    public OutfitGeneratedResource createFootwear(@RequestBody CreateOutfitGeneratedResource request) {
        return mapper.toResource(outfitgeneratedService.create(mapper.toModel(request)));
    }

    @PutMapping("{Id}")
    public OutfitGeneratedResource updateOutfitGenerated(@PathVariable Long Id,
            @RequestBody UpdateOutfitGeneratedResource request) {
        return mapper.toResource(outfitgeneratedService.update(Id, mapper.toModel(request)));
    }

    @DeleteMapping("{Id}")
    public ResponseEntity<?> deleteTop(@PathVariable Long Id) {
        return outfitgeneratedService.delete(Id);
    }

}
