package pe.edu.upc.raze.posts.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.raze.posts.domain.service.PostService;

@RestController
@RequestMapping("api/v1/users/{userId}/posts")
public class UserPostsController {
    private final PostService postService;
}
