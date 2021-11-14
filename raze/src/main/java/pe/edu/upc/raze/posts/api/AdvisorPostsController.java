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
import pe.edu.upc.raze.users.customers.model.enums.UserType;

@RestController
@RequestMapping("api/v1/useradvisors/{userId}/posts")
public class AdvisorPostsController {
    private final PostService postService;
    private final PostMapper mapper;

    public AdvisorPostsController(PostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.mapper = postMapper;
    }

    @GetMapping
    public Page<PostResource> getAllPostsByUserId(@PathVariable Long userId, Pageable pageable){
        return mapper.modelListToPage(postService.getAllByUserId(userId, UserType.Advisor), pageable);
    }

    @PostMapping
    public PostResource createPost(@PathVariable Long userId,
                                   @RequestBody CreatePostResource request){
        return mapper.toResource(postService.create(userId, UserType.Advisor, mapper.toModel(request), request.getInterestId(), request.getFashionId()));
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
        return mapper.toResource(postService.getByIdAndUserId(userId, postId, UserType.Advisor));
    }

    @DeleteMapping("{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long userId,
                                        @PathVariable Long postId) {
        return postService.delete(userId, postId, UserType.Advisor);
    }
}
