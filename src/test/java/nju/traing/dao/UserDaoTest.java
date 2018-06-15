package nju.traing.dao;

import nju.traing.TraingApplication;
import nju.traing.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TraingApplication.class)
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testAdd() throws Exception {

        User user = new User();
        user.setUsername("bcy");
        user.setPassword("123");
        userDao.save(user);
    }

    @Test
    public void testFind() throws Exception {
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}