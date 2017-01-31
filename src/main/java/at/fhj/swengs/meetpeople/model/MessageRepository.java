package at.fhj.swengs.meetpeople.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
    Message save(Message message);

    List<Message> findByUser(User user);

    List<Message> findAll();

    Message findByMessageID(Long messageId);
}
