package pe.edu.upc.raze.consultancies.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.consultancies.domain.services.OutfitService;
import pe.edu.upc.raze.consultancies.mapping.OutfitMapper;
import pe.edu.upc.raze.consultancies.resource.CreateOutfitResource;
import pe.edu.upc.raze.consultancies.resource.OutfitResource;

import java.util.List;

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


        var outfitsResource = outfitMapper.modelListToPage(outfitService.GetAll(),pageable);
        return outfitsResource;
    }

    @GetMapping("outfitId")
    public OutfitResource GetOutfitById(@PathVariable Long outfitId){

        var outfitResource = outfitMapper.toResource(outfitService.GetById(outfitId));
        return outfitResource;
    }

    @PostMapping
    public  OutfitResource CreateOutfit(@RequestBody CreateOutfitResource request){
        var outfit = outfitMapper.toModel(request);

        var outfitResource=outfitMapper.toResource(outfitService.Create(outfit));

        return outfitMapper.toResource(outfit);
    }
}
