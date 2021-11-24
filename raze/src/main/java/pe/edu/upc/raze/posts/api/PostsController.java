package pe.edu.upc.raze.posts.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.posts.domain.service.PostService;
import pe.edu.upc.raze.posts.mapping.PostMapper;
import pe.edu.upc.raze.posts.resource.PostResource;

import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {
    @Autowired
    private PostService postService;

    @Autowired
    private PostMapper mapper;

    @GetMapping
    public List<PostResource> getAllPosts() {
        return mapper.modelListToPage(postService.getAll());
    }

    @GetMapping("{postId}")
    public PostResource getPostById(@PathVariable("postId") Long postId) {
        return mapper.toResource(postService.getById(postId));
    }
}
