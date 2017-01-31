package at.fhj.swengs.meetpeople.service;

import at.fhj.swengs.meetpeople.model.Message;
import at.fhj.swengs.meetpeople.model.User;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
public interface MessageService {
    Message save(Message message);

    List<Message> findAll();

    List<Message> findByUser(User user);

    Message findByMessageID(Long messageId);
}
