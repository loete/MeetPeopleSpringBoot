package at.fhj.swengs.meetpeople.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment,Long> {
    Comment save(Comment comment);

    List<Comment> findByMessageId(Long messageId);

    Comment findOne(Long commentId);
}
