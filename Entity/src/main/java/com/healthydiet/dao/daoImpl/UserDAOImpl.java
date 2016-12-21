package com.healthydiet.dao.daoImpl;

import com.healthydiet.entity.User;
import com.healthydiet.dao.UserDAO;
import com.healthydiet.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by Яна on 29.10.2016.
 */
public class UserDAOImpl implements UserDAO {
    public void addUser(User user) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),  "Ошибка сохранения", JOptionPane.OK_OPTION);
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }

    }
    public void updateUser(User user) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        }  finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public User getUserById(int id) {
        Session session = null;
        User user = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            user = (User) session.load(User.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return user;
    }
    public User getUserByUsernameAndPassword(String username, String password){
        Session session = null;
        User user = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(User.class);
            user = (User) criteria.add(Restrictions.eq("username", username))
                    .add(Restrictions.eq("password", password))
                    .uniqueResult();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return user;
    }

    public void deleteUser(User user) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),  "Ошибка удаления", JOptionPane.OK_OPTION);
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
