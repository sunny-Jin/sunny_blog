package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.model.User;

/**
 * Created by jzy on 2017/8/27.
 */
@Repository
public interface UserDao {
    User getUser(@Param("userName") String userName, @Param("password") String password);
}
