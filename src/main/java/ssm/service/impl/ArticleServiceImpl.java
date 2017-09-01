package ssm.service.impl;

import org.springframework.stereotype.Service;
import ssm.dao.ArticleDao;
import ssm.model.Article;
import ssm.service.ArticleService;

import javax.annotation.Resource;
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

    public Article getContent() {
        return articleDao.getContent();
    }

    public int addContent(String content) {
        return articleDao.addContent(content);
    }
}
