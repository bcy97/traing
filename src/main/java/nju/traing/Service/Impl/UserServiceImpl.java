package nju.traing.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import nju.traing.Service.UserService;
import nju.traing.dao.UserDao;
import nju.traing.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public boolean addUser(String username, String password, Date createTime) {
        if (username == null || username.equals("") || password == null || password.equals("") || createTime == null) {
            return false;
        }
        User user = new User(createTime, username, password);
        try {
            userDao.save(user);
        } catch (Exception e) {
            log.debug("UserServiceImpl.addUser. User info:", user);
            return false;
        }
        return true;
    }

    @Override
    public boolean login(String username, String password) {
        if (username == null || username.equals("") || password == null || password.equals("")) {
            return false;
        }
        try {
            User user = userDao.findByUsername(username);
            if (user == null) {
                return false;
            } else if (user.getPassword() == password) {
                return true;
            }
        } catch (Exception e) {
            log.debug("UserServiceImpl.login. User name:", username);
            return false;
        }
        return true;
    }

}
