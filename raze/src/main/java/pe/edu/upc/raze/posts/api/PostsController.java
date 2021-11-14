package pe.edu.upc.raze.posts.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.raze.posts.domain.service.PostService;
import pe.edu.upc.raze.posts.mapping.PostMapper;
import pe.edu.upc.raze.posts.resource.PostResource;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {
    @Autowired
    private PostService postService;

    @Autowired
    private PostMapper mapper;

    @GetMapping
    public Page<PostResource> getAllPosts(Pageable pageable) {
        return mapper.modelListToPage(postService.getAll(), pageable);
    }

    @GetMapping("{postId}")
    public PostResource getPostById(@PathVariable("postId") Long postId) {
        return mapper.toResource(postService.getById(postId));
    }
}
