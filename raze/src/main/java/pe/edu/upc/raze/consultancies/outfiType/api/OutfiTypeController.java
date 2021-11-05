package pe.edu.upc.raze.consultancies.outfiType.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.consultancies.outfiType.domain.services.OutfiTypeService;
import pe.edu.upc.raze.consultancies.outfiType.mapping.OutfiTypeMapper;
import pe.edu.upc.raze.consultancies.outfiType.resource.CreateOutfiTypeResource;
import pe.edu.upc.raze.consultancies.outfiType.resource.OutfiTypeResource;
import pe.edu.upc.raze.consultancies.outfiType.resource.UpdateOutfiTypeResource;

@RestController
@RequestMapping("/api/v1/outfiTypes")
public class OutfiTypeController {
    private final OutfiTypeService outfiTypeService;
    private final OutfiTypeMapper outfiTypeMapper;

    public OutfiTypeController(OutfiTypeService outfiTypeService, OutfiTypeMapper outfiTypeMapper) {
        this.outfiTypeService = outfiTypeService;
        this.outfiTypeMapper = outfiTypeMapper;
    }

    @GetMapping
    public Page<OutfiTypeResource> GetAllOutfiTypes(Pageable pageable){


        var outfiTypesResource = outfiTypeMapper.modelListToPage(outfiTypeService.GetAll(),pageable);
        return outfiTypesResource;
    }

    @GetMapping("{outfiTypeId}")
    public OutfiTypeResource GetOutfiTypeById(@PathVariable Long outfiTypeId){

        var outfiTypeResource = outfiTypeMapper.toResource(outfiTypeService.GetById(outfiTypeId));
        return outfiTypeResource;
    }

    @PostMapping
    public  OutfiTypeResource CreateOutfiType(@RequestBody CreateOutfiTypeResource request){
        var outfiType = outfiTypeMapper.toModel(request);

        var outfiTypeCreated = outfiTypeService.Create(outfiType);

        var outfiTypeResource=outfiTypeMapper.toResource(outfiTypeCreated);

        return outfiTypeResource;
    }

    @PutMapping("{outfiTypeId}")
    public OutfiTypeResource updateOutfiType(@PathVariable Long outfiTypeId, @RequestBody UpdateOutfiTypeResource request){
        return outfiTypeMapper.toResource(outfiTypeService.Update(outfiTypeId,outfiTypeMapper.toModel(request)));
    }

    @DeleteMapping("{outfiTypeId}")
    public ResponseEntity<?> deleteOutfiType(@PathVariable Long outfiTypeId){
        return outfiTypeService.Delete(outfiTypeId);
    }
}
