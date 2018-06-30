package nju.traing.dao;

import nju.traing.entity.Order;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {
}
