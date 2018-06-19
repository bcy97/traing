package nju.traing.dao;

import nju.traing.TraingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TraingApplication.class)
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    public void addOrder() throws Exception {



    }
}
