package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.model.User;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by jzy on 2017/8/27.
 */
@Repository
public interface UserDao {
    User getUser(@Param("userName") String userName, @Param("password") String password);
    Integer updateUser(@Param("id") int id, @Param("password") String password);
    List<User> getAllUsers();
    int addUser(@Param("userName") String userName, @Param("nickName") String nickName,
                @Param("email") String email, @Param("password") String password);
}
