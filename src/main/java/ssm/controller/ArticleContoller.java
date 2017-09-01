package ssm.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.model.Article;
import ssm.service.ArticleService;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/Article")
public class ArticleContoller {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/showArticles.do")
    @ResponseBody
    /*
    * 显示文章列表
    * */
    public String showArticles()
    {
        List<Article> articles  = articleService.getArticles();
        JSONArray jsonArray = JSONArray.fromObject(articles);
        return jsonArray.toString();
    }

    /*
    * 将文章相关信息写入数据库
    * */
    @RequestMapping("/getContent.do")
    @ResponseBody
    public void getContent(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String str = request.getParameter("content");
        if(str != null)
        {
            //写入数据库
            articleService.addContent(str);
        }
        else
        {

        }
    }

    /*
    * 显示文章信息
    * */
    @RequestMapping("/displayContent.do")
    @ResponseBody
    public String displayContent(HttpServletRequest request)
    {
        Article article = articleService.getContent();
        String str = article.getContent();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("article",str);
        return jsonObject.toString();
    }

}
