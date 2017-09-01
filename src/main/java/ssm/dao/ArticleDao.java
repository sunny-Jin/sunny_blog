package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.model.Article;

import java.util.List;

@Repository
public interface ArticleDao {
    /*
    * 获取文章列表Dao接口
    * */
    List<Article> getArticles();

    /*
    * 获取文章内容*/
    Article getContent();

    /*
    * 文章入库*/
    int addContent(@Param("content") String content);
}
