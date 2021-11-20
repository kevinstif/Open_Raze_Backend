package pe.edu.upc.raze.posts.posts.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.posts.posts.domain.service.PostService;
import pe.edu.upc.raze.posts.posts.mapping.PostMapper;
import pe.edu.upc.raze.posts.posts.resource.CreatedPostResource;
import pe.edu.upc.raze.posts.posts.resource.PostResource;
import pe.edu.upc.raze.posts.posts.resource.UpdatePostResource;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private PostMapper postMapper;

    @GetMapping
    public Page<PostResource>getAllPosts(Pageable pageable){
        return postMapper.modelListToPage(postService.getAll(),pageable);
    }

    @GetMapping("{postId}")
    public PostResource getPostById(@PathVariable("postId") Long postId){
        return postMapper.toResource(postService.getById(postId));
    }

    @PostMapping
    public PostResource createPost(@RequestBody CreatedPostResource request){
        return postMapper.toResource(postService.create(postMapper.toModel(request)));
    }

    @PutMapping("{postId}")
    public PostResource updatePost(@PathVariable Long postId, @RequestBody UpdatePostResource request){
        return postMapper.toResource(postService.update(postId, postMapper.toModel(request)));
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId){
        return postService.delete(postId);
    }

}
