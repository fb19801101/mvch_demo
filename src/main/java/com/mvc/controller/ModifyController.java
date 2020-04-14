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
@RequestMapping("table")
public class ModifyController {
     private String resultJson;

    /*
     * struts 接收参数三种方式：属性方式接收，JavaBean方式接收，ModelDriven方式接收参数,前两种都必须设置get和set方法
     * */
    //Spring 注入方式
    @Autowired
    private UserService userService;

    @RequestMapping("toDisplay")
    public String toDisplay() {
          return "table";
    }

    @RequestMapping("display")
    public String display(HttpServletRequest request, HttpServletResponse response) {
        JSONObject result = new JSONObject();

        result.put("message", "登录成功");
        result.put("status", "success");
        resultJson = result.toString();
        request.setAttribute("resultJson", resultJson);
        List<Student> students = userService.findAllStudent();
        request.setAttribute("students", students);

        return "table";
    }
}