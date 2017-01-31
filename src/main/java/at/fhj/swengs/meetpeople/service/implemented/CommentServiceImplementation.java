package at.fhj.swengs.meetpeople.service.implemented;

import at.fhj.swengs.meetpeople.model.Comment;
import at.fhj.swengs.meetpeople.model.CommentRepository;
import at.fhj.swengs.meetpeople.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Override
    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public List<Comment> findByMessageId(Long messageId) {
        return commentRepo.findByMessageId(messageId);
    }

    @Override
    public Comment findOne(Long commentId) {
        return commentRepo.findOne(commentId);
    }
}
