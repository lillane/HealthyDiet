package com.healthydiet.dao.daoImpl;

import com.healthydiet.dao.RecipeTypeDAO;
import com.healthydiet.entity.RecipeType;
import com.healthydiet.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import javax.swing.*;
import java.sql.SQLException;
import java.util.*;

public class RecipeTypeDAOImpl implements RecipeTypeDAO {
    public Set<RecipeType> getRecipeTypes() throws SQLException{
        Session session = null;
        Set<RecipeType> recipeTypeList = new HashSet<RecipeType>() {
        };
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(RecipeType.class);
            criteria.addOrder(Order.asc("name"));
            recipeTypeList = (Set<RecipeType>) criteria.list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return recipeTypeList;
    }

    public RecipeType getRecipeTypeById(int id) throws SQLException{
        Session session = null;
        RecipeType recipeType = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            recipeType = (RecipeType) session.load(RecipeType.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return recipeType;
    }

}
