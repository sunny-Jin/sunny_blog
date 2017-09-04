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
    JSONObject jsonObject = new JSONObject();
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
    @RequestMapping("/addArticle.do")
    @ResponseBody
    public void addArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
        String title = request.getParameter("title");
        String tags = request.getParameter("tags");
        String type = request.getParameter("type");
        String summary= request.getParameter("summary");
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
        int id = Integer.parseInt(request.getParameter("id"));
        Article article = articleService.getContent(id);
        String str = article.getContent();
        //JSONObject jsonObject = new JSONObject();
        jsonObject.put("article",str);
        return jsonObject.toString();
    }
    /*
    * 删除文章信息
    * */
    @RequestMapping("/delArticle.do")
    @ResponseBody
    public String delArticle(HttpServletRequest request)
    {
        int id = Integer.parseInt(request.getParameter("id"));
        int delFlag = articleService.delArticle(id);
        if(delFlag > 0)
        {
            jsonObject.put("Flag",true);
        }

        return jsonObject.toString();
    }

}
