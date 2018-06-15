package nju.traing.dao;

import nju.traing.TraingApplication;
import nju.traing.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TraingApplication.class)
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    public  void addOrder(){
        Order order=new Order();
        order.setCourseId(1);
        order.setCreateTime(new Date());
        order.setState(1);
        order.setOrgId(1);
        order.setUserId(1);
        order.setStartDate(new Date());
        orderDao.save(order);
    }
}
