package com.mvc.service;

import com.mvc.entity.User;
import com.mvc.entity.Student;

import java.util.List;


/**
 * @Author: zengsm.
 * @Description:
 * @Date:Created in 2017/12/6 15:30.
 * @Modified By:
 */
public interface UserService
{
    List<User> findAllUser();

    int saveUserEntity(User user);

    boolean saveOrUpdateUserEntity(User user);

    boolean updateUserEntity(User user);

    User getUserById(Integer id);

    User getUserByName(String name);

    boolean deleteUserById(Integer id);

    boolean deleteUserByName(String name);

    boolean deleteUserByEntity(User user);


    List<Student> findAllStudent();

    int saveStudentEntity(Student student);

    boolean saveOrUpdateStudentEntity(Student student);

    boolean updateStudentEntity(Student student);

    boolean updateStudent(Student student);

    Student getStudentByName(String name);

    Student getStudentByNo(String no);

    boolean deleteStudentById(Integer id);

    boolean deleteStudentByNo(String no);

    boolean deleteStudentByEntity(Student student);
}
