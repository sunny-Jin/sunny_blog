package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.ArticleDao;
import ssm.model.Article;
import ssm.model.User;
import ssm.service.ArticleService;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;

    /*
    * 获取文章列表实现
    */
    public List<Article> getArticles()
    {

        return articleDao.getArticles();
    }

    public Article getContent(int id) {
        return articleDao.getContent(id);
    }

    public int addContent(String content) {
        return articleDao.addContent(content);
    }

    public int delArticle(int id) {
        return articleDao.delArticle(id);
    }

    public int addArticle(String title, String tags, int type, String summary, String content, Timestamp publishTime, User u)
    {
        return articleDao.addArticle(title,tags,type,summary,content,publishTime,u);
    }
}
