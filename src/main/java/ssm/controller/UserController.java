package ssm.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.model.User;
import ssm.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by jzy on 2017/8/27.
 */
@Controller
@RequestMapping("/User")
public class UserController {

    private static final String SESSION_USER = "session_user";

    @Resource
    private UserService userService ;

    @RequestMapping("/Login.do")
    @ResponseBody
    public String Login(HttpServletRequest request,Model model,HttpSession session)
    {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String validate = request.getParameter("validate");
        JSONObject json = new JSONObject();
        boolean flag = false;
        String s = String.valueOf(session.getAttribute("SESSION_CODE"));
        flag = Judge(validate,s);
        if(flag == false)
        {
            json.put("fail",true);
            return json.toJSONString();
        }
        User u  = userService.getUser(userName,password);
        if(u!=null)
        {
            json.put("success", true);
            request.getSession().setAttribute(SESSION_USER,u);
            return json.toJSONString();
        }
        else
        {
            json.put("fail",false);
            return json.toJSONString();
        }
    }

    public boolean Judge(String validate,String s)
    {
        if(s.equals(validate))
        {
            return true;
        }
        return  false;
    }

    @RequestMapping("/update.do")
    @ResponseBody
    public String update(HttpServletRequest req)
    {
        int id = Integer.parseInt(req.getParameter("id"));
        String password = req.getParameter("password");

        int n = userService.updateUser(id,password);
        JSONObject jsonObject = new JSONObject();
        if(n>0)
        {
            jsonObject.put("success",true);
            return jsonObject.toJSONString();
        }
        else
        {
            return jsonObject.toJSONString();
        }

    }

    @RequestMapping("/getSession.do")
    @ResponseBody
    public String getSession(HttpServletRequest req)
    {
        JSONObject json = new JSONObject();
        Object o = req.getSession().getAttribute(SESSION_USER);
        User u = (User) o;
        json.put("user",u);
        return json.toJSONString();
    }

    @RequestMapping("/logout.do")
    @ResponseBody
    public String logout(HttpServletRequest req)
    {
       req.getSession().removeAttribute(SESSION_USER);
       JSONObject json = new JSONObject();
       json.put("success",true);
       return json.toJSONString();
    }
}
