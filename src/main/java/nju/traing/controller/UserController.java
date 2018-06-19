package nju.traing.controller;

import nju.traing.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public boolean addUser(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpSession session) {
        if (userService.login(username, password)) {
            session.putValue("username", username);
            return true;
        } else {
            return false;
        }
    }

}
