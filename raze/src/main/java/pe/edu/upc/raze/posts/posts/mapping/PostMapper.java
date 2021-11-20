package pe.edu.upc.raze.posts.posts.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import pe.edu.upc.raze.posts.posts.domain.model.entity.Post;
import pe.edu.upc.raze.posts.posts.resource.CreatedPostResource;
import pe.edu.upc.raze.posts.posts.resource.PostResource;
import pe.edu.upc.raze.posts.posts.resource.UpdatePostResource;
import pe.edu.upc.raze.shared.mapping.EnhancedModelMapper;
import java.io.Serializable;
import java.util.List;

public class PostMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public PostResource toResource(Post model) {
        return mapper.map(model, PostResource.class);
    }

    public Page<PostResource> modelListToPage(List<Post> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, PostResource.class), pageable, modelList.size());
    }

    public Post toModel(CreatedPostResource resource){
        return mapper.map(resource, Post.class);
    }

    public Post toModel(UpdatePostResource resource){
        return mapper.map(resource, Post.class);
    }
}
