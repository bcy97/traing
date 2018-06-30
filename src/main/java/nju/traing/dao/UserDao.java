package nju.traing.dao;

import nju.traing.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    List<User> findByCreateTimeBetween(Date start, Date end);

}
