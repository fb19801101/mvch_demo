package com.mvc.dao;

import com.mvc.entity.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


/**
 * @Author: zsm.
 * @Description:
 * @Date:Created in 2017/12/16 22:50.
 * @Modified By:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml"})
public class HibernateTest
{
    @Autowired
    private StudentDao studentDao;

    @Test
    public void findAllEntity() throws Exception
    {
        List<Student> students = studentDao.findAllStudent();
        Assert.assertTrue(students.size() > 8);
    }

    @Test
    public void saveEntity() throws Exception
    {
        Student student = getEntity();
        Integer id = studentDao.saveStudentEntity(student);
        Assert.assertTrue(id > 8);
    }

    @Test
    public void saveOrUpdateEntity() throws Exception
    {
        Student student = getEntity();
        student.setId(10);
        studentDao.saveOrUpdateStudentEntity(student);
    }

    @Test
    public void updateEntity() throws Exception
    {
        Student student = getEntity();
        student.setId(10);
        studentDao.saveStudentEntity(student);
    }

    @Test
    public void getEntityByName() throws Exception
    {
        Student student = studentDao.getStudentByName("杜玉萍");
        Assert.assertEquals("113", student.getUserNo());
    }

    @Test
    public void getEntityByNo() throws Exception
    {
        Student student = studentDao.getStudentByNo("114");
        Assert.assertEquals("李元芳", student.getUserName());
    }

    @Test
    public void deleteEntityById() throws Exception
    {
        studentDao.deleteStudentById(10);
    }

    @Test
    public void deleteEntityByNo() throws Exception
    {
        studentDao.deleteStudentByNo("114");
    }

    @Test
    public void deleteEntity() throws Exception
    {
        Student student = getEntity();
        student.setId(10);
        studentDao.deleteStudentByEntity(student);
    }

    private Student getEntity() throws ParseException
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Student student = new Student();
        student.setUserName("李元芳");
        student.setUserNo("114");
        student.setUserPwd("efafa13");
        student.setUserSex("男");
        Date bir = formatter.parse("1990-06-03 00:00:00");
        student.setUserBirth(new Timestamp(bir.getTime()));
        student.setUserClass("95035");
        student.setDateCreate(new Timestamp(System.currentTimeMillis()));
        student.setDateUpdate(new Timestamp(-1));
        return student;
    }
}