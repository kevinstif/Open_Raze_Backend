package pe.edu.upc.raze.consultancies.outfits.api;

import lombok.var;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.consultancies.outfits.domain.services.OutfitService;
import pe.edu.upc.raze.consultancies.outfits.mapping.OutfitMapper;
import pe.edu.upc.raze.consultancies.outfits.resource.CreateOutfitResource;
import pe.edu.upc.raze.consultancies.outfits.resource.OutfitResource;
import pe.edu.upc.raze.consultancies.outfits.resource.UpdateOutfitResource;

@RestController
@RequestMapping("/api/v1/outfits")
public class OutfitController {
    private final OutfitService outfitService;
    private final OutfitMapper outfitMapper;

    public OutfitController(OutfitService outfitService, OutfitMapper outfitMapper) {
        this.outfitService = outfitService;
        this.outfitMapper = outfitMapper;
    }

    @GetMapping
    public Page<OutfitResource> GetAllOutfits(Pageable pageable){


        return outfitMapper.modelListToPage(outfitService.GetAll(),pageable);
    }

    @GetMapping("{outfitId}")
    public OutfitResource GetOutfitById(@PathVariable Long outfitId){

        return outfitMapper.toResource(outfitService.GetById(outfitId));
    }

    @PostMapping
    public  OutfitResource CreateOutfit(@RequestBody CreateOutfitResource request){
        return outfitMapper.toResource(outfitService.Create(outfitMapper.toModel(request)));
    }

    @PutMapping("{outfitId}")
    public OutfitResource updateOutfit(@PathVariable Long outfitId, @RequestBody UpdateOutfitResource request){
        return outfitMapper.toResource(outfitService.Update(outfitId,outfitMapper.toModel(request)));
    }

    @DeleteMapping("{outfitId}")
    public ResponseEntity<?> deleteOutfit(@PathVariable Long outfitId){
        return outfitService.Delete(outfitId);
    }
}
