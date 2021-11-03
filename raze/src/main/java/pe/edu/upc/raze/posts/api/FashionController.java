package pe.edu.upc.raze.posts.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.posts.domain.service.FashionService;
import pe.edu.upc.raze.posts.mapping.FashionMapper;
import pe.edu.upc.raze.posts.resource.CreateFashionResource;
import pe.edu.upc.raze.posts.resource.FashionResource;
import pe.edu.upc.raze.posts.resource.UpdateFashionResource;

@RestController
@RequestMapping("/api/v1/fashions")
public class FashionController {

    @Autowired
    private FashionService fashionService;

    @Autowired
    private FashionMapper mapper;

    @GetMapping
    public Page<FashionResource> getAllFashions(Pageable pageable){
        return mapper.modelListToPage(fashionService.getAll(), pageable);
    }

    @GetMapping("{fashionId}")
    public FashionResource getFashionById(@PathVariable("fashionId") Long fashionId) {
        return mapper.toResource(fashionService.getById(fashionId));
    }



    @PostMapping
    public FashionResource createFashion(@RequestBody CreateFashionResource request){
        return mapper.toResource(fashionService.create(mapper.toModel(request)));
    }

    @PutMapping("{fashionId}")
    public FashionResource updateFashion(@PathVariable Long fashionId, @RequestBody UpdateFashionResource request){
        return mapper.toResource(fashionService.update(fashionId, mapper.toModel(request)));
    }

    @DeleteMapping("{fashionId}")
    public ResponseEntity<?> deletePost(@PathVariable Long fashionId){
        return fashionService.delete(fashionId);
    }
}
