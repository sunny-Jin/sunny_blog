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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import ssm.model.User;

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
    public void addArticle(HttpServletRequest request,HttpSession session) throws ServletException,IOException
    {
        String title = request.getParameter("title");
        String tags = request.getParameter("tags");
        int type = Integer.parseInt(request.getParameter("type"));
        String summary= request.getParameter("summary");
        String content = request.getParameter("content");
//        Date now = new Date();
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = format.format(now);
        java.sql.Timestamp publishTime = new java.sql.Timestamp(new Date().getTime());  //发表时间
       User u = (User)session.getAttribute("session_user");


        if(content != null)
        {
            //写入数据库
            articleService.addArticle(title,tags,type,summary,content,publishTime,u);
          //  articleService.addContent(str);
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
      //  String str = article.getContent();
        //JSONObject jsonObject = new JSONObject();
        jsonObject.put("article",article);
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

    @RequestMapping("/showDrafts.do")
    @ResponseBody
    public String showDrafts(HttpServletRequest request)
    {
        List<Article> list = articleService.getDrafts();
        JSONArray jsonArray = JSONArray.fromObject(list);
        return jsonArray.toString();
    }

    @RequestMapping("/delDraft.do")
    @ResponseBody
    public String delDraft(HttpServletRequest request)
    {
        int id = Integer.parseInt(request.getParameter("id"));
        int delFlag = articleService.delDraft(id);
        if(delFlag > 0)
        {
            jsonObject.put("Flag",true);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/getLastArticles.do")
    @ResponseBody
    public String getLastArticles(HttpServletRequest request)
    {
        List<Article> articles = articleService.getLastArticles();
        JSONArray jsonArray = JSONArray.fromObject(articles);
        return  jsonArray.toString();
    }
}
