package com.mvc.controller;

import com.mvc.entity.User;
import com.mvc.util.ControllerUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;


/**
 * Get请求，跳转方式
 *
 * @Author: zsm.
 * @Description:
 * @Date:Created in 2017/11/15 22:59.
 * @Modified By:
 */
@Controller
@RequestMapping("servlet/get")
public class GetController
{
    /**
     * 无请求参数,http://localhost:8080/get/find
     */
    @RequestMapping(value = "find", method = RequestMethod.GET)
    public String findUser()
    {
        System.out.println("test request");
        //转发到能够匹配 /redirect 的 controller 上
//        return "redirect:/login/toLogin";
        return "forward:/jump/redirect";
    }

    /**
     * 1.通过请求携带数据直接获取参数，http://localhost:8080/get/finduser?username="admin"&password="123456"
     *
     * @param username
     * @param password
     */
    @RequestMapping(value = "findUser", method = RequestMethod.GET)
    public ModelAndView findUserByName(String username, String password)
    {
        System.out.println("username " + username);
        System.out.println("password " + password);
        //重定向到到 jumpToTestRedirect方法  redirectandparam
        return new ModelAndView("redirect:/jump/redirectParam");
    }

    /**
     * 2.通过@PathVariable获取路径中的参数,http://localhost:8080/get/finduser1/admin/123456
     *
     * @param username
     * @param password
     */
    @RequestMapping(value = "findUser1/{username}/{password}", method = RequestMethod.GET)
    public ModelAndView findUserByName1(@PathVariable String username, @PathVariable String password)
    {
        // 重定向到到  jumpToTestRedirectAndParam方法  redirectandparam
        ModelAndView modelAndView = new ModelAndView(
            "redirect:/jump/redirectParam?message=" + username + "&status=" + password + "&data=findUser1跳转成功");
        System.out.println("username " + username);
        System.out.println("password " + password);
        return modelAndView;
    }

    /**
     * 3.通过HttpServletRequest 获取参数,http://localhost:8080/get/finduser2?username="admin"&password="123456"
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "findUser2", method = RequestMethod.GET)
    public String findUserByName2(HttpServletRequest request, HttpServletResponse response,
                                  RedirectAttributes redirectAttributes)
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username is:" + username);
        System.out.println("password is:" + password);
        redirectAttributes.addAttribute("message", username);
        redirectAttributes.addAttribute("status", password);
        redirectAttributes.addAttribute("data", "findUser2");
        return "redirect:/jump/redirectParam";
    }

    /**
     * 4.通过RequestParam 获取参数,http://localhost:8080/get/finduser3?username="admin"&password="123456"
     *
     * @param username
     * @param password
     */
    @RequestMapping(value = "findUser3", method = RequestMethod.GET)
    public void findUserByName3(@RequestParam(value = "username", required = false) String username,
                                @RequestParam("password") String password, HttpServletResponse response)
        throws IOException
    {
        System.out.println("username is:" + username);
        System.out.println("password is:" + password);
        //使用HttpServletResponse 重定向到另一个视图

        response.sendRedirect("/mvch_demo/jump/result");
    }

    /**
     * 5.通过Bean转化为对象 获取参数,http://localhost:8080/get/finduser4?username="admin"&password="123456"
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "findUser4", method = RequestMethod.GET)
    public void findUserByName4(User user, HttpServletRequest
        request, HttpServletResponse response)
        throws IOException
    {
        System.out.println("username is:" + user.getUsername());
        System.out.println("password is:" + user.getPassword());
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        //通过HTTP ServletResponse的API直接输出
        String message = "通过 HTTP ServletResponse 的 API 直接输出";
        response.getWriter().println(message);
    }

    /**
     * 6.通过HttpServletRequest  getQueryString获取参数，http://localhost:8080/get/finduser5?username="admin"&password="123456"
     *
     * @param request
     * @param response
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "findUser5", method = RequestMethod.GET)
    public void findUserByName5(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        //getQueryString获取到请求参数字符串：username="admin"&password="123456"
        String param = URLDecoder.decode(request.getQueryString(), "UTF-8");
        Map map = ControllerUtil.convertURLParamToMap(param);
        System.out.println("username is:" + map.get("username"));
        System.out.println("password is:" + map.get("password"));
        request.getRequestDispatcher("/jump/result").forward(request, response);
    }
}
