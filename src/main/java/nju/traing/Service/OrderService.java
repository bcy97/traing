package nju.traing.Service;

import nju.traing.entity.Order;

public interface OrderService {

    boolean addOrder(Order order);

    boolean cancelOrder(int orderId);

    boolean dropOrder(int orderId);

    boolean payOrder(int orderId);
}
