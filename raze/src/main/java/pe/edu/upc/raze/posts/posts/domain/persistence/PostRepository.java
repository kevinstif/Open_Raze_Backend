package pe.edu.upc.raze.posts.posts.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.raze.posts.posts.domain.model.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
