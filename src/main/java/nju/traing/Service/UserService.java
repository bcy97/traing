package nju.traing.Service;

import java.util.Date;

public interface UserService {

    boolean addUser(String username, String password, Date createTime);

    boolean login(String username,String password);
}
