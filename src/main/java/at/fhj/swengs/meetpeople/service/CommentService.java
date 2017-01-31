package at.fhj.swengs.meetpeople.service;

import at.fhj.swengs.meetpeople.model.Comment;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
public interface CommentService {
    Comment save(Comment comment);

    List<Comment> findByMessageId(Long messageId);

    Comment findOne(Long commentId);
}
