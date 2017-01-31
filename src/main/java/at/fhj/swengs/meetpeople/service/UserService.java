package at.fhj.swengs.meetpeople.service;

import at.fhj.swengs.meetpeople.model.User;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
public interface UserService {

    List<User> findAllUsers();

    User findByUserName(String userName);

    User save(User user);
}
