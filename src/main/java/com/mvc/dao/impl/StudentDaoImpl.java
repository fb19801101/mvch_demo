package com.mvc.dao.impl;

import com.mvc.dao.StudentDao;
import com.mvc.entity.Student;
import com.mvc.entity.StudentPK;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
@Repository("studentDao")
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao
{
    /*sessionFactory依赖注入*/
//    @Resource(name="sessionFactory")
    //这里的属性名一定要和配置中的属性名一致
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Student> findAllStudent() {
        Session session = sessionFactory.openSession();
        //将所有的数据查询出来并放到List集合里 User是表对应的实例名称
        List<Student> list = session.createQuery("from Student").list();
        session.close();
        return list;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int saveStudentEntity(Student student) {
        Session session = sessionFactory.openSession();
        //返回插入数据id
        Transaction tr = session.beginTransaction();
        StudentPK id = (StudentPK)session.save(student);
        tr.commit();
        session.close();
        return id.getId();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdateStudentEntity(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.saveOrUpdate(student);
        tr.commit();
        session.close();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateStudentEntity(Student student) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        String sql = "update Student set " +
                "userName=:userName," +
                "userPwd=:userPwd," +
                "userSex=:userSex," +
                "userBirth=:userBirth," +
                "userClass=:userClass," +
                "dateCreate=:dateCreate," +
                "dateUpdate=:dateUpdate " +
                "where id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", student.getId());
        query.setParameter("userName", student.getUserName());
        query.setParameter("userPwd", student.getUserPwd());
        query.setParameter("userSex", student.getUserSex());
        query.setParameter("userBirth", student.getUserBirth());
        query.setParameter("userClass", student.getUserClass());
        query.setParameter("dateCreate", student.getDateCreate());
        query.setParameter("dateUpdate", student.getDateUpdate());
        query.executeUpdate();
        session.close();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Student getStudentByName(String name) {
//        Session session = sessionFactory.getCurrentSession();
        Session session = sessionFactory.openSession();
        //根据id查询,结果返回 Student.class
//        Student student = (Student)session.get(Student.class, 2);
        //将所有的数据查询出来并放到List集合里 User是表对应的实例名称
        List<Student> students = session.createQuery("from Student where userName='" + name + "'").list();
        session.close();

        if(students.size() == 1) {
            return students.get(0);
        }

        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Student getStudentByNo(String no) {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student where userNo='" + no + "'").list();
        session.close();
        if(students.size() == 1) {
            return students.get(0);
        }

        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteStudentById(Integer id) {
        Session session = sessionFactory.openSession();
        String sql = "delete from Student where id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        query.executeUpdate();
        session.close();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteStudentByNo(String no) {
        Session session = sessionFactory.openSession();
        String sql = "delete from Student where userNo=:no";
        Query query = session.createQuery(sql);
        query.setParameter("no", no);
        query.executeUpdate();
        session.close();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteStudentByEntity(Student student) {
        Session session = sessionFactory.openSession();
        //传入实例对象，比较id删除对应行，，没有id匹配就不删除
        session.beginTransaction();
        session.delete(Student.class.getName(), student);
        session.getTransaction().commit();
        session.close();
    }
}