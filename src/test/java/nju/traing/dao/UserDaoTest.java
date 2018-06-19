package nju.traing.dao;

import nju.traing.TraingApplication;
import nju.traing.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Random;

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

    @Test
    public void addUser() throws Exception {
        long test = System.currentTimeMillis();
        long base_time = 1420041600000l;
        long end15 = 1451577600000l;
        long end16 = 1483200000000l;
        long end17 = 1514736000000l;
        long end_time = 1529424000000l;
        for (int i = 0; i < 2000; i++) {
            long time = 0;
            double p = Math.random();
            if (p <= 0.2) {
                time = base_time + (long) (Math.random() * (end15 - base_time));
            } else if (p <= 0.5 && p > 0.2) {
                time = end15 + (long) (Math.random() * (end16 - end15));
            } else if (p <= 0.8 && p > 0.5) {
                time = end16 + (long) (Math.random() * (end17 - end16));
            } else {
                time = end17 + (long) (Math.random() * (end_time - end17));
            }
            Date date = new Date(time);
            User user = new User(date, getRandomChar((int) (Math.random() * 10) + 5), "123");
            System.out.println(user);
            userDao.save(user);
        }
    }

    public String getRandomChar(int length) {            //生成随机字符串
        char[] chr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            buffer.append(chr[random.nextInt(36)]);
        }
        return buffer.toString();
    }
}
