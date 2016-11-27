package com.healthydiet.implementations;

import com.healthydiet.entity.Category;
import com.healthydiet.interfaces.CategoryDAO;
import com.healthydiet.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Яна on 29.10.2016.
 */
public class CategoryDAOImpl implements CategoryDAO {
    public List<Category> getCategories() throws SQLException{
        Session session = null;
        List<Category> categoryList = new ArrayList<Category>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Category.class);
            criteria.addOrder(Order.asc("name"));
            categoryList = criteria.list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return categoryList;
    }

    public Category getCategoryById(int id) throws SQLException{
        Session session = null;
        Category category = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            category = (Category) session.load(Category.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return category;
    }

}
