package nju.traing.Service.Impl;

import nju.traing.Service.OrderService;
import nju.traing.dao.OrderDao;
import nju.traing.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public boolean addOrder(Order order) {
        if (order == null) {
            return false;
        }
        try {
            orderDao.save(order);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean cancelOrder(int orderId) {
        return false;
    }

    @Override
    public boolean dropOrder(int orderId) {
        return false;
    }

    @Override
    public boolean payOrder(int orderId) {
        return false;
    }

}
