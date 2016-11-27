package com.healthydiet.controller;

import com.healthydiet.entity.Category;
import com.healthydiet.entity.Product;
import com.healthydiet.entity.Recipe;
import com.healthydiet.implementations.CategoryDAOImpl;
import com.healthydiet.implementations.ProductDAOImpl;
import com.healthydiet.implementations.RecipeDAOImpl;
import com.healthydiet.utils.JsonMap;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class RecipeServlet extends HttpServlet {


    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/json;charset=utf-8");

        int id = 0;
        String idString = req.getParameter("id");
        if (null != idString && idString.length() > 0) {
            id = Integer.parseInt(idString);
        }

        int categoryId = 0;
        String categoryIdString = req.getParameter("categoryId");
        if (null != categoryIdString && categoryIdString.length() > 0) {
            categoryId = Integer.parseInt(categoryIdString);
        }
        JSONObject json = new JSONObject();
//

        try {
            RecipeDAOImpl recipeDAO = new RecipeDAOImpl();
            if (id > 0) {
                Recipe recipe = recipeDAO.getRecipeById(id);
                json.put("recipes", JsonMap.recipeToJson(recipe));
            } else {
                List<Recipe> recipes = recipeDAO.getRecipes(categoryId);

                json.put("recipes", JsonMap.recipeToJson(recipes));
            }

            PrintWriter pw = resp.getWriter();
            pw.println(json.toJSONString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String categoryIdString = req.getParameter("categoryId");
        int categoryId = 0;
        if (null != categoryIdString && categoryIdString.length() > 0) {
            categoryId = Integer.parseInt(categoryIdString);
        }
        String products = req.getParameter("products");


        List<Integer> productIds = new ArrayList<Integer>();
        for (String productIdStr : products.split(",")) {
            productIds.add(Integer.parseInt(productIdStr));
        }

        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setDescription(description);
        try {

            CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
            Category category = categoryDAO.getCategoryById(categoryId);
            recipe.setCategory(category);

            ProductDAOImpl productDAO = new ProductDAOImpl();
            recipe.setProducts(productDAO.getProducts(productIds));

            RecipeDAOImpl recipeDAO = new RecipeDAOImpl();
            recipeDAO.addRecipe(recipe);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        }


        resp.setStatus(201);

        JSONObject json = new JSONObject();
        json.put("recipes", JsonMap.recipeToJson(recipe));
        PrintWriter pw = resp.getWriter();
        pw.println(json.toJSONString());

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");

        int id = 0;
        String idString = req.getParameter("id");
        if (null != idString && idString.length() > 0) {
            id = Integer.parseInt(idString);
        }

        try {
            RecipeDAOImpl recipeDAO = new RecipeDAOImpl();
            recipeDAO.deleteRecipeById(id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        }
        resp.setStatus(204);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = 0;
        String idString = req.getParameter("id");
        if (null != idString && idString.length() > 0) {
            id = Integer.parseInt(idString);
        }

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String categoryIdString = req.getParameter("categoryId");
        int categoryId = 0;
        if (null != categoryIdString && categoryIdString.length() > 0) {
            categoryId = Integer.parseInt(categoryIdString);
        }
        String products = req.getParameter("products");
        List<Integer> productIds = new ArrayList<Integer>();
        for (String productIdStr : products.split(",")) {
            productIds.add(Integer.parseInt(productIdStr));
        }

        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(name);
        recipe.setDescription(description);

        try {

            CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
            Category category = categoryDAO.getCategoryById(categoryId);
            recipe.setCategory(category);

            ProductDAOImpl productDAO = new ProductDAOImpl();
            recipe.setProducts(productDAO.getProducts(productIds));

            RecipeDAOImpl recipeDAO = new RecipeDAOImpl();

            recipeDAO.updateRecipe(recipe);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        }


        resp.setStatus(200);

        JSONObject json = new JSONObject();
        json.put("recipes", JsonMap.recipeToJson(recipe));
        PrintWriter pw = resp.getWriter();
        pw.println(json.toJSONString());
    }
}

