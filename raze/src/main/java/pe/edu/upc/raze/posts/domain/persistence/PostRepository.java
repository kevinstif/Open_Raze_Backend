package pe.edu.upc.raze.posts.domain.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.raze.posts.domain.model.entity.Post;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserAdvisedId(Long userId);
    List<Post> findByUserAdvisorId(Long userId);
    Optional<Post> findByIdAndUserAdvisedId(Long postId, Long userId);
    Optional<Post> findByIdAndUserAdvisorId(Long postId, Long userId);
}
