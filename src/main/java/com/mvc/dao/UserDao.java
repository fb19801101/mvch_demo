package com.mvc.dao;

import com.mvc.entity.User;

import java.util.List;


/**
 * @Author: zengsm.
 * @Description:
 * @Date:Created in 2017/12/6 15:32.
 * @Modified By:
 */
public interface UserDao
{
    List<User> findAllUser();

    int saveUserEntity(User user);

    void saveOrUpdateUserEntity(User user);

    void updateUserEntity(User user);

    User getUserById(Integer id);

    User getUserByName(String name);

    void deleteUserById(Integer id);

    void deleteUserByName(String name);

    void deleteUserByEntity(User user);
}