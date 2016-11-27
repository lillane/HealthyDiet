package com.healthydiet.implementations;

import com.healthydiet.entity.Product;
import com.healthydiet.interfaces.ProductDAO;
import com.healthydiet.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by Яна on 29.10.2016.
 */
public class ProductDAOImpl implements ProductDAO {
    public void addProduct (Product product) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),  "Ошибка сохранения", JOptionPane.OK_OPTION);
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public void updateProduct(Product product) throws SQLException{
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        }  finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
    public Product getProductById(int id) throws SQLException{
        Session session = null;
        Product product = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            product = (Product) session.load(Product.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return product;
    }

    public Product getProductByName (String name) throws SQLException{
        Session session = null;
        Product product = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Product.class);
            product = (Product) criteria.add(Restrictions.eq("name", name))
                    .uniqueResult();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return product;
    }

    public List<Product> getProducts() throws SQLException{
        Session session = null;
        List<Product> productList = new ArrayList<Product>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Product.class);
            criteria.addOrder(Order.asc("name"));
            productList = criteria.list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return productList;
    }

    public List<Product> getProducts(List id) throws SQLException{
        Session session = null;
        List<Product> productList = new ArrayList<Product>();
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Product.class);
            criteria.add(Restrictions.in("id", id));
            criteria.addOrder(Order.asc("name"));
            productList = criteria.list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return productList;
    }


    public void deleteRecipeById(int productId) throws SQLException {
        Session session = null;
        Product product = new Product();
        product.setId(productId);
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        }  finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }
}
