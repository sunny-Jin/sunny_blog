package ssm.service;


import ssm.model.Article;
import ssm.model.User;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public interface ArticleService {
    /**
     * 获取文章列表
     */

    List<Article> getArticles();

    Article getContent(int id);
    int addContent(String content);
    int delArticle(int id);
    int addArticle(String title, String tags, int type, String summary, String content, Timestamp publishTime, User u);

    List<Article> getDrafts();

    int delDraft(int id);

    List<Article> getLastArticles();
}
