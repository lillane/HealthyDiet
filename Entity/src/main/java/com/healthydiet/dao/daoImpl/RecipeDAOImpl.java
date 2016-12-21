package com.healthydiet.dao.daoImpl;

import com.healthydiet.entity.Recipe;
import com.healthydiet.dao.RecipeDAO;
import com.healthydiet.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Яна on 05.11.2016.
 */
public class RecipeDAOImpl implements RecipeDAO {
    public void addRecipe (Recipe recipe) throws SQLException{
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(recipe);
            session.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),  "Ошибка сохранения", JOptionPane.OK_OPTION);
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public void updateRecipe(Recipe recipe) throws SQLException{
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(recipe);
            session.getTransaction().commit();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        }  finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public Recipe getRecipeById(int id) throws SQLException{
        Session session = null;
        Recipe recipe = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            recipe = (Recipe) session.load(Recipe.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return recipe;
    }

    public List<Recipe> findRecipesByName (String keyword) throws SQLException{
        Session session = null;
        List<Recipe> recipeList = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Recipe.class);
            criteria.add(Restrictions.ilike("name", "%"+keyword+"%"));
            criteria.addOrder(Order.asc("name"));
            recipeList = criteria.list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return recipeList;
    }


    public List<Recipe> getRecipes(int recipeTypeId) throws SQLException{
        Session session = null;
        List<Recipe> recipeList = null;

        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Recipe.class); //класс. который формирует sql-запросы
            /* addOrder - добавить сортировку
            asc - по возрастанию, desc - по убыванию.
            Order - класс, который формирует сортировку. */
            criteria.addOrder(Order.asc("name")); //задаем сортировку по полю name
            criteria.add(Restrictions.eq("recipeType.id", recipeTypeId));
            recipeList = criteria.list();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка сохранения", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return recipeList;
    }

    public void deleteRecipeById(int recipeId) throws SQLException {
        Session session = null;
        Recipe recipe = new Recipe();
        recipe.setId(recipeId);
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(recipe);
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
