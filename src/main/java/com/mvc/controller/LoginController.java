package com.mvc.controller;

import com.mvc.entity.Student;
import com.mvc.entity.User;
import com.mvc.service.UserService;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {
    //前台传到后台需要set，后台传到前台需要get
    // 用户名-必须与页面请求的对应表单username值相同
    private String username;

    // 密码必须与页面请求的对应表单password值相同
    private String password;

    private String resultJson;

    private static Logger logger = Logger.getLogger("secondLogger");

    /*
     * struts 接收参数三种方式：属性方式接收，JavaBean方式接收，ModelDriven方式接收参数,前两种都必须设置get和set方法
     * */
    //Spring 注入方式
    @Autowired
    private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(HttpServletRequest request, Model model) { //参数中传入Model
        model.addAttribute("name","com.mvc.controller"); //指定Model的值
        model.addAttribute("url","http://www.baidu.com/"); //指定Model的值

        String path = request.getSession().getServletContext().getRealPath(File.separator);
        System.setProperty("log4j.path",path);

        return "login/login";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();
        username = request.getParameter("username");
        password = request.getParameter("password");
        User user = userService.getUserByName(username);

        if (user != null) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
            {
                logger.info("The User Login Success.");
                result.put("message", "登录成功");
                result.put("status", "success");
                resultJson = result.toString();
                request.setAttribute("resultJson", resultJson);
                request.setAttribute("user", user);
                List<Student> students = userService.findAllStudent();
                request.setAttribute("students", students);
                request.setAttribute("message", "登录成功");
                writeResponseData(request, response, result);

                String bean = request.getParameter("bean");
                if(bean != null && bean.equals("UseBean")) {
                    return "login/result";
                } else {
                    return "login/success";
                }
            } else {
                logger.debug("The User Login Error, Because Password Is Failed.");
                result.put("message", "登录失败");
                result.put("status", "error");
                resultJson = result.toString();
                request.setAttribute("resultJson", resultJson);
                request.setAttribute("user", user);
                request.setAttribute("message", "登录失败");
                writeResponseData(request, response, result);
                return "login/error";
            }
        }
        else {
            logger.error("The User Login Failed, Because The User Is Failed.");
            result.put("message", "用户失效");
            result.put("status", "failed");
            resultJson = result.toString();
            request.setAttribute("resultJson", resultJson);
            request.setAttribute("message", "用户失效");
            writeResponseData(request, response, result);
            return "login/failed";
        }
    }

    private void writeResponseData(HttpServletRequest request, HttpServletResponse response, Object data) {
        response.setContentType("text/html;charset=utf-8");
        try
        {
            PrintWriter out = response.getWriter();
            out.println(data.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResultJson() {
        return resultJson;
    }

    public void setResultJson(String resultJson) {
        this.resultJson = resultJson;
    }
}