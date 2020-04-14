package com.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.mvc.entity.Student;
import com.mvc.entity.User;
import com.mvc.service.UserService;
import com.mvc.util.DateFormatUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Post请求总共分为两种方式传输数据：
 * 一种是以表单From的方式提交数据；contentType:application/x-www-form-urlencoded
 * 一种是请求体RequestBody的方式提交数据；application/json;charset=utf-8
 *
 * @Author: zsm.
 * @Description:
 * @Date:Created in 2017/11/5 23:26.
 * @Modified By:
 */
@Controller
@RequestMapping("table")
public class TableController
{
    @Autowired
    private UserService userService;

    /**
     * 1.通过HttpServletRequest接收，请求头设置为contentType:application/x-www-form-urlencoded
     * postRequest(url,JSON.stringify(param),"application/x-www-form-urlencoded",function () { });
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject json = BaseController.readValueFromRequest(request);
        Student student = toStudent(json);
        if (student != null) {
            userService.saveStudentEntity(student);
        }
    }

    /**
     * 2.RequestBody获取Bean对象,application/json;charset=utf-8，数据必须转换为JSON格式
     * postRequest(url,JSON.stringify(param),"application/json;charset=utf-8",function () { });
     *
     * @param student
     * @param request
     * @param response
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void update(@RequestBody Student student,
                      HttpServletRequest request, HttpServletResponse response) {
        if (student != null) {
            DateFormatUtil dfu = new DateFormatUtil();
            student.setUserBirth(dfu.parse("1980-11-1"));
            student.setDateCreate(dfu.parse("2019-11-1"));
            student.setDateUpdate(dfu.parse("2020-09-1"));
            userService.updateStudentEntity(student);
        }
    }

    /**
     * 3.用注解@RequestParam绑定请求参数到方法入参,application/x-www-form-urlencoded,数据以表单提交，不能转为JSON格式
     * postRequest(url,param,"application/x-www-form-urlencoded",function () { });
     *
     * @param userNo
     * @param request
     * @param response
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public void delete(@RequestParam("userNo") String userNo,
                       HttpServletRequest request, HttpServletResponse response) {
        if (userNo != null) {
            userService.deleteStudentByNo(userNo);
        }
    }

    /**
     * 4.用对象映射接收参数，application/x-www-form-urlencoded,数据以表单提交，不能转为JSON格式
     * postRequest(url,param,"application/x-www-form-urlencoded",function () { });
     *
     * @param student
     * @param request
     * @param response
     */
    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public void query(Student student,
                       HttpServletRequest request, HttpServletResponse response) {
        if(student != null) {
            Student student1 = userService.getStudentByNo(student.getUserNo());
            List<Student> students = new ArrayList<>();
            students.add(student1);

            request.setAttribute("students",students);
            response.setHeader("Refresh","2");
        }
    }

    public Student toStudent(JSONObject json) {
        if (json.size() == 9) {
            Student student = new Student();
            JSONArray ja = json.getJSONArray("id");
            student.setId(Integer.valueOf(ja.getString(0)));
            ja = json.getJSONArray("userNo");
            student.setUserNo(ja.getString(0));
            ja = json.getJSONArray("userName");
            student.setUserName(ja.getString(0));
            ja = json.getJSONArray("userPwd");
            student.setUserPwd(ja.getString(0));
            ja = json.getJSONArray("userSex");
            student.setUserSex(ja.getString(0));
            ja = json.getJSONArray("userBirth");
            String s = ja.getString(0);
            DateFormatUtil dfu = new DateFormatUtil();
            student.setUserBirth(dfu.parse(s));
            ja = json.getJSONArray("userClass");
            student.setUserClass(ja.getString(0));
            ja = json.getJSONArray("dateCreate");
            s = ja.getString(0);
            student.setDateCreate(dfu.parse(s));
            ja = json.getJSONArray("dateUpdate");
            s = ja.getString(0);
            student.setDateUpdate(dfu.parse(s));
            return student;
        }

        return null;
    }
}