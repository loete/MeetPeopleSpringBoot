package at.fhj.swengs.meetpeople.controller;

import at.fhj.swengs.meetpeople.service.UserService;
import at.fhj.swengs.meetpeople.model.User;
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
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping("user/users")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @RequestMapping(value="/user/userName", method = RequestMethod.POST)
    public User findByUserName(@RequestBody String userName) {
        return userService.findByUserName(userName);
    }

    @RequestMapping(value = "/user/update", method=RequestMethod.POST)
    public User updateUser(@RequestBody User user) {
        return userService.save(user);
    }

}
