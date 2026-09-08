package example.Practice5.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import example.Practice5.model.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity , Integer>{

}
