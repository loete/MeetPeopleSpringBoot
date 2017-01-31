package at.fhj.swengs.meetpeople.controller;

import at.fhj.swengs.meetpeople.model.Comment;
import at.fhj.swengs.meetpeople.model.Message;
import at.fhj.swengs.meetpeople.service.CommentService;
import at.fhj.swengs.meetpeople.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
@RestController
@RequestMapping("/rest")
public class CommentResources {
    @Autowired
    private MessageService messageService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public void addComment(@RequestBody Comment comment){
        Message message = messageService.findByMessageID(comment.getMessageID());
        List<Comment> commentList = message.getCommentList();
        comment.setMessage(message);
        commentService.save(comment);
    }
}
