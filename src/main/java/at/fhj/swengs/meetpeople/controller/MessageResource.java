package at.fhj.swengs.meetpeople.controller;

import at.fhj.swengs.meetpeople.model.Message;
import at.fhj.swengs.meetpeople.model.User;
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
public class MessageResource {


    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/message/add", method= RequestMethod.POST)
    public Message addMessage(@RequestBody Message message){
        return messageService.save(message);
    }

    @RequestMapping(value = "/message/user", method= RequestMethod.POST)
    public List<Message> getMessagesByUser(@RequestBody User user){
        return messageService.findByUser(user);
    }

    @RequestMapping(value = "/message/messageId", method= RequestMethod.POST)
    public Message getMessageByMessageId(@RequestBody Long messageId){
        return messageService.findByMessageID(messageId);
    }

    @RequestMapping(value = "/message/update", method= RequestMethod.POST)
    public void updateMessage(@RequestBody Message message){
        Message currentMessage = messageService.findByMessageID(message.getMessageID());
        currentMessage.setLikes(message.getLikes());
        messageService.save(currentMessage);
    }

}
