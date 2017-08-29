package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.model.Article;
import ssm.service.WriteService;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Controller
@RequestMapping("/Write")
public class WriteController {

    @Autowired
    private WriteService writeService;
    @RequestMapping("/getContent.do")
    @ResponseBody
    public void getContent(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
    {
       /* ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String content = request.getParameter("editorValue");
        if(content != null)
        {
            //将数据存入数据库
            //将内容设置进属性
            ServletOutputStream out = response.getOutputStream();
            request.setAttribute("content",content);
            //转发到content.jsp
         //   request.getRequestDispatcher("../content.jsp").forward(request, response);
            outputStream.writeTo(out);
            outputStream.flush();
        }
        else
        {
            //提示未输入内容
            response.getWriter().append("内容为空!");
        }*/


       String str = request.getParameter("content");
       if(str != null)
       {
           //写入数据库
           writeService.addContent(str);
       }
       else
       {

       }
    }

    @RequestMapping("/displayContent.do")
    @ResponseBody
    public String displayContent(HttpServletRequest request)
    {
        Article article = writeService.getContent();
        String str = article.getContent();
        return str;
    }
}
