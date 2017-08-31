package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.UserDao;
import ssm.model.User;
import ssm.service.UserService;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by jzy on 2017/8/27.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public User getUser(String userName,String password)
    {
        return userDao.getUser(userName,password);
    }

    public Integer updateUser(int id, String password){ return userDao.updateUser(id,password); }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
