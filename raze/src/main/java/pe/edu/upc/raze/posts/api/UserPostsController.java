package pe.edu.upc.raze.posts.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.raze.posts.domain.service.PostService;
import pe.edu.upc.raze.posts.mapping.PostMapper;
import pe.edu.upc.raze.posts.resource.CreatePostResource;
import pe.edu.upc.raze.posts.resource.PostResource;
import pe.edu.upc.raze.posts.resource.UpdatePostResource;

import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("api/v1/users/{userId}/posts")
public class UserPostsController {
    private final PostService postService;
    private final PostMapper mapper;

    public UserPostsController(PostService postService, PostMapper mapper) {
        this.postService = postService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PostResource> getAllPostsByUserId(@PathVariable Long userId){
        return mapper.modelListToPage(postService.getAllByUserId(userId));
    }

    @PostMapping
    public PostResource createPost(@PathVariable Long userId,
                                   @RequestBody CreatePostResource request){
        return mapper.toResource(postService.create(userId, mapper.toModel(request)));
    }

    @PutMapping("{postId}")
    public PostResource updatePost(@PathVariable Long userId,
                                   @PathVariable Long postId,
                                   @RequestBody UpdatePostResource request){
        return mapper.toResource(postService.update(userId, postId, mapper.toModel(request)));
    }

    @GetMapping("{postId}")
    public PostResource getPostById(@PathVariable("userId") Long userId,
                                    @PathVariable("postId") Long postId){
        return mapper.toResource(postService.getByIdAndUserId(userId, postId));
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long userId,
                                        @PathVariable Long postId) {
        return postService.delete(userId, postId);
    }
}
