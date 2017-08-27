package ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jzy on 2017/8/21.
 */
@Controller
public class HelloController {
    @RequestMapping("/Hello/hello")
    public  String hello(Model model)
    {
        model.addAttribute("username","张三");
        return "/hello";
    }

    @RequestMapping("/Hello/world")
    public String world(Model model)
    {
        model.addAttribute("username","李四");
        return "/world";
    }
}
