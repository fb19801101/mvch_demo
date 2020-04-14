package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("servlet")
public class HttpController {
    @RequestMapping("toHttp")
    public String toHttp(HttpServletRequest request, Model model) { //参数中传入Model
        return "servlet/http";
    }

    @RequestMapping("toGet")
    public String toGet(HttpServletRequest request, Model model) { //参数中传入Model
        return "servlet/get";
    }

    @RequestMapping("toPost")
    public String toPost(HttpServletRequest request, Model model) { //参数中传入Model
        return "servlet/post";
    }
}