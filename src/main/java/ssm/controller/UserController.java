package ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.model.User;
import ssm.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by jzy on 2017/8/27.
 */
@Controller
@RequestMapping("/User")
public class UserController {
    @Resource
    private UserService userService ;

    @RequestMapping("/Login.do")
    @ResponseBody
    public String Login(HttpServletRequest request,Model model)
    {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        try {
            User u  = userService.getUser(userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject json = new JSONObject();
        json.put("success", true);
       /* if(u!=null)
        {

            return json.toJSONString();
        }
        else
        {
            return json.toJSONString();
        }*/
        return json.toJSONString();
    }

}
