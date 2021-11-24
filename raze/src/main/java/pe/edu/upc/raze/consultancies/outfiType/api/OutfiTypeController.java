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

import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
    public List<OutfiTypeResource> GetAllOutfiTypes(){


        return outfiTypeMapper.modelListToPage(outfiTypeService.GetAll());
    }

    @GetMapping("{outfiTypeId}")
    public OutfiTypeResource GetOutfiTypeById(@PathVariable Long outfiTypeId){

        return outfiTypeMapper.toResource(outfiTypeService.GetById(outfiTypeId));
    }

    @PostMapping
    public  OutfiTypeResource CreateOutfiType(@RequestBody CreateOutfiTypeResource request){

        return outfiTypeMapper.toResource(outfiTypeService.Create(outfiTypeMapper.toModel(request)));
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
