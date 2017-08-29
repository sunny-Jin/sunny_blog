package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.model.Article;

@Repository
public interface WriteDao {
     Article getContent();
     int addContent(@Param("content") String content);
}
