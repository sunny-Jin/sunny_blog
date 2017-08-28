package ssm.service;

import ssm.model.User;

/**
 * Created by jzy on 2017/8/27.
 */
public interface UserService {
    User getUser(String userName,String password);
    Integer  updateUser(int id,String password);
}
