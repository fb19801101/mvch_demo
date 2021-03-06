package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @Author: zengsm.
 * @Description:
 * @Date:Created in 2018/1/12 10:23.
 * @Modified By:
 */
@Controller
@RequestMapping("/jump")
public class JumpController
{
    @RequestMapping("result")
    public String jumpToResult()
    {
        return "servlet/result";
    }

    @RequestMapping("redirect")
    public String jumpToRedirect()
    {
        //跳转到direct.jsp页面,返回文件名direct
        return "servlet/redirect";
    }

    @RequestMapping("redirectParam")
    public ModelAndView jumpToRedirectParam(String message, String status, String data)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", message);
        modelAndView.addObject("status", status);
        modelAndView.addObject("data", data);
        //跳转到testredirect.jsp页面
        modelAndView.setViewName("servlet/redirect");
        return modelAndView;
    }

    @RequestMapping("download")
    public String jumpToDownLoad()
    {
        return "file/download";
    }

    @RequestMapping("refresh")
    public void jumpToRefresh(HttpServletResponse response)
    {
        //3秒后自动跳转到首页
        response.setHeader("Refresh", "3; URL=http://www.baidu.com");
    }

    @RequestMapping("header")
    public void jumpToHeader(HttpServletResponse response)
    {
        response.setHeader("Location", "../index.jsp");
        //设置302状态码，等同于response.setStatus(302)
        response.setStatus(HttpServletResponse.SC_FOUND);
    }

    @RequestMapping("sendRedirect")
    public void jumpToSendRedirect(HttpServletResponse response)
        throws IOException
    {
        response.sendRedirect("http://www.baidu.com");
    }

    /**
     * 通过forward跳转页面
     *
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("forward")
    public String jumpToForward(HttpServletResponse response)
        throws IOException
    {
        return "forward:../index";
    }

    /**
     * 重定向传值，通过Flash属性RedirectAttributes，并必须配置 <annotation-driven/>
     *
     * @param response
     * @param redirectAttributes 重定向参数传递
     * @throws IOException
     */
    @RequestMapping("redirectAttributes")
    public void redirectAttributes(HttpServletResponse response, RedirectAttributes redirectAttributes)
        throws IOException
    {
        redirectAttributes.addFlashAttribute("param", "this had a redirect!");
        response.sendRedirect("http://www.baidu.com");
    }

    /**
     * 打开新窗口，跳转页面，直接在浏览器访问接口跳转到新窗口(一般不用这种方式)
     */
    @RequestMapping("redirectWrite")
    public void redirectWrite(HttpServletResponse response, HttpServletRequest request, String url)
    {
        String context = "<script languge='javascript'>window.open(\"" + url + "\");</script>";
        try
        {
            response.getWriter().write(context);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @RequestMapping("i18n")
    public String i18nTest(HttpServletResponse response, RedirectAttributes redirectAttributes)
        throws IOException
    {
        //response.sendRedirect("i18n");
        return "i18n";
    }
}
