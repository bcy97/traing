package nju.traing.dao;

import nju.traing.TraingApplication;
import nju.traing.entity.Course;
import nju.traing.entity.Order;
import nju.traing.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TraingApplication.class)
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrganizationDao organizationDao;
    @Autowired
    private CourseDao courseDao;

    @Test
    public void addOrder() throws Exception {

        long test = System.currentTimeMillis();
        long base_time = 1420041600000l;
        long end15 = 1451577600000l;
        long end16 = 1483200000000l;
        long end17 = 1514736000000l;
        long end_time = 1529424000000l;

        long month = (end17 - end16) / 12;

//        List<User> user15 = userDao.findByCreateTimeBetween(new Date(base_time), new Date(end15));
//        List<User> user16 = userDao.findByCreateTimeBetween(new Date(end15), new Date(end16));
//        List<User> user17 = userDao.findByCreateTimeBetween(new Date(end16), new Date(end17));
//        List<User> user18 = userDao.findByCreateTimeBetween(new Date(end17), new Date(end_time));

        List<User> users = userDao.findAll();
        List<Order> orders = new ArrayList<>();
        int i = 0;
        for (User user : users) {
            if (i <= 800) {
                i++;
                continue;
            }
            if (i % 200 == 0 && i != 0) {
                orderDao.saveAll(orders);
                orders = new ArrayList<>();
            }
            List<Course> courses = courseDao.findAllByStartDateBetween(user.getCreateTime(), new Date(end_time));
            int num = (int) (Math.random() * 12) + 3;
            num = num > courses.size() ? (int) (Math.random() * courses.size()) : num;
            for (int j = 0; j < num; j++) {

                int courseNum = (int) (Math.random() * courses.size());

                Course course = courses.get(courseNum);

                Order order = new Order();
                order.setUserId(user.getId());
                order.setCourseId(course.getId());
                order.setOrgId(course.getOrgId());
                order.setStartDate(course.getStartDate());
                order.setValue(course.getPrice());
                order.setState(2);
                order.setCreateTime(new Date(course.getStartDate().getTime() - (int) (Math.random() * month)));
                order.setPayDate(new Date(order.getCreateTime().getTime() + (int) (Math.random() * (month / 30 / 24 / 2))));
                orders.add(order);
            }

            i++;
        }

        if (i % 200 != 0) {
            orderDao.saveAll(orders);
        }

    }
}
