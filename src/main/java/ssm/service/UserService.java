package ssm.service;

import ssm.model.User;

import java.util.List;

/**
 * Created by jzy on 2017/8/27.
 */
public interface UserService {
    User getUser(String userName,String password);
    Integer  updateUser(int id,String password);
    List<User> getAllUsers();
}
