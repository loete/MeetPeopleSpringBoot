package at.fhj.swengs.meetpeople.service.implemented;

import at.fhj.swengs.meetpeople.model.UserRepository;
import at.fhj.swengs.meetpeople.service.UserService;
import at.fhj.swengs.meetpeople.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findByUserName(String userName) {
        return userRepo.findByUserName(userName);
    }

    @Override
    public User save(User user) {
        return userRepo.save(user);
    }
}
