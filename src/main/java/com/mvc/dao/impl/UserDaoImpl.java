package com.mvc.dao.impl;

import com.mvc.dao.UserDao;
import com.mvc.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @Author: zengsm.
 * @Description:
 * @Date:Created in 2017/12/6 15:36.
 * @Modified By:
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao
{
    /*sessionFactory依赖注入*/
//    @Resource(name="sessionFactory")
    //这里的属性名一定要和配置中的属性名一致
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<User> findAllUser() {
        Session session = sessionFactory.openSession();
        //将所有的数据查询出来并放到List集合里 User是表对应的实例名称
        List<User> list = session.createQuery("from User").list();
        session.close();
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int saveUserEntity(User user) {
        Session session = sessionFactory.openSession();
        //返回插入数据id
        session.beginTransaction();
        int id = (int)session.save(user);
        session.getTransaction().commit();
        session.close();
        return id;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdateUserEntity(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserEntity(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User getUserByName(String name) {
//        Session session = sessionFactory.getCurrentSession();
        Session session = sessionFactory.openSession();
        //根据id查询,结果返回 Student.class
//        Student student = (Student)session.get(Student.class, 2);
        //将所有的数据查询出来并放到List集合里 User是表对应的实例名称
        String sql = "from User where username='" + name + "'";
        List<User> users = session.createQuery(sql).list();
        session.close();
        if(users.size() == 1) {
            return users.get(0);
        }

        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User getUserById(Integer id) {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User where id='" + id + "'").list();
        session.close();
        if(users.size() == 1) {
            return users.get(0);
        }

        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserById(Integer id) {
        Session session = sessionFactory.openSession();
        String sql = "delete from User where id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
        session.close();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserByName(String name) {
        Session session = sessionFactory.openSession();
        String sql = "delete from User where username=:name";
        Query query = session.createQuery(sql);
        query.setParameter("name", name);
        query.executeUpdate();
        session.close();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserByEntity(User user) {
        Session session = sessionFactory.openSession();
        //传入实例对象，比较id删除对应行，，没有id匹配就不删除
        session.beginTransaction();
        session.delete(User.class.getName(), user);
        session.getTransaction().commit();
        session.close();
    }
}