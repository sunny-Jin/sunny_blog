package ssm.service;


import ssm.model.Article;

import java.util.List;


public interface ArticleService {
    /**
     * 获取文章列表
     */

    List<Article> getArticles();

    Article getContent(int id);
    int addContent(String content);
    int delArticle(int id);
}
