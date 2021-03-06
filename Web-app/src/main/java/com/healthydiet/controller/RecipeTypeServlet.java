package com.healthydiet.controller;

import com.healthydiet.dao.daoImpl.RecipeTypeDAOImpl;
import com.healthydiet.utils.JsonMap;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;


public class RecipeTypeServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/json;charset=utf-8");

        JSONObject json = new JSONObject();

        try {
            RecipeTypeDAOImpl recipeTypeDAO = new RecipeTypeDAOImpl();
            json.put("recipeTypes", JsonMap.recipeTypeToJson(recipeTypeDAO.getRecipeTypes()));

            PrintWriter pw = resp.getWriter();
            pw.println(json.toJSONString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        }
    }
}
