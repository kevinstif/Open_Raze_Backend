package pe.edu.upc.raze.consultancies.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.consultancies.domain.services.OutfitTypeService;
import pe.edu.upc.raze.consultancies.mapping.OutfitTypeMapper;
import pe.edu.upc.raze.consultancies.resource.CreateOutfitTypeResource;
import pe.edu.upc.raze.consultancies.resource.OutfitTypeResource;
import pe.edu.upc.raze.consultancies.resource.UpdateOutfitTypeResource;

import java.util.List;

@RestController
@RequestMapping("/api/v1/outfitTypes")
public class OutfitTypeController {
    private final OutfitTypeService outfitTypeService;
    private final OutfitTypeMapper outfitTypeMapper;

    public OutfitTypeController(OutfitTypeService outfitTypeService, OutfitTypeMapper outfitTypeMapper) {
        this.outfitTypeService = outfitTypeService;
        this.outfitTypeMapper = outfitTypeMapper;
    }

    @GetMapping
    public Page<OutfitTypeResource> GetAllOutfitTypes(Pageable pageable){


        var outfitTypesResource = outfitTypeMapper.modelListToPage(outfitTypeService.GetAll(),pageable);
        return outfitTypesResource;
    }

    @GetMapping("{outfitTypeId}")
    public OutfitTypeResource GetOutfitTypeById(@PathVariable Long outfitTypeId){

        var outfitTypeResource = outfitTypeMapper.toResource(outfitTypeService.GetById(outfitTypeId));
        return outfitTypeResource;
    }

    @PostMapping
    public  OutfitTypeResource CreateOutfitType(@RequestBody CreateOutfitTypeResource request){
        var outfitType = outfitTypeMapper.toModel(request);

        var outfitTypeCreated = outfitTypeService.Create(outfitType);

        var outfitTypeResource=outfitTypeMapper.toResource(outfitTypeCreated);

        return outfitTypeResource;
    }

    @PutMapping("{outfitTypeId}")
    public OutfitTypeResource updateOutfitType(@PathVariable Long outfitTypeId, @RequestBody UpdateOutfitTypeResource request){
        return outfitTypeMapper.toResource(outfitTypeService.Update(outfitTypeId,outfitTypeMapper.toModel(request)));
    }

    @DeleteMapping("{outfitTypeId}")
    public ResponseEntity<?> deleteOutfitType(@PathVariable Long outfitTypeId){
        return outfitTypeService.Delete(outfitTypeId);
    }
}
