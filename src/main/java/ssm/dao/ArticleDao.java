package ssm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ssm.model.Article;
import ssm.model.User;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ArticleDao {
    /*
    * 获取文章列表Dao接口
    * */
    List<Article> getArticles();

    /*
    * 获取文章内容*/
    Article getContent(@Param("id") int id);

    /*
    * 文章入库*/
    int addContent(@Param("content") String content);

    /*
    * 删除文章
    * */
    int delArticle(@Param("id") int id);

    int addArticle(@Param("title") String title, @Param("tags") String tags, @Param("type") int type, @Param("summary")
                   String summary, @Param("content") String content, @Param("publishTime")Timestamp publishTiem,@Param("u")
                           User u);
    /*
    * 获取草稿箱文章
    * */
    List<Article> getDrafts();

    int delDraft(@Param("id") int id);
}
