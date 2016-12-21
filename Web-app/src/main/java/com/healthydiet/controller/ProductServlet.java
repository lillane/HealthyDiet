package com.healthydiet.controller;

import com.healthydiet.entity.Product;
import com.healthydiet.dao.daoImpl.ProductDAOImpl;
import com.healthydiet.utils.JsonMap;
import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;


public class ProductServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/json;charset=utf-8");

        int id = 0;
        String idString = req.getParameter("id");
        if (null != idString && idString.length() > 0) {
            id = Integer.parseInt(idString);
        }
        JSONObject json = new JSONObject();

        try {
            ProductDAOImpl productDAO = new ProductDAOImpl();
            if (id > 0) {
                Product product = productDAO.getProductById(id);
                json.put("products", JsonMap.productToJson(product));
            } else {
                json.put("products", JsonMap.productToJson(productDAO.getProducts()));
            }

            PrintWriter pw = resp.getWriter();
            pw.println(json.toJSONString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        }
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
            ProductDAOImpl productDAO = new ProductDAOImpl();
            productDAO.deleteRecipeById(id);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        }
        resp.setStatus(204);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String kcal = req.getParameter("kcal");
        String proteins = req.getParameter("proteins");
        String fats = req.getParameter("fats");
        String carbohydrates = req.getParameter("carbohydrates");



        Product product = new Product();
        product.setName(name);
        product.setKcal(Double.parseDouble(kcal));
        product.setProteins(Double.parseDouble(proteins));
        product.setFats(Double.parseDouble(fats));
        product.setCarbohydrates(Double.parseDouble(carbohydrates));

        try {
            ProductDAOImpl productDAO = new ProductDAOImpl();
            productDAO.addProduct(product);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        }
        resp.setStatus(201);

        JSONObject json = new JSONObject();
        json.put("products", JsonMap.productToJson(product));
        PrintWriter pw = resp.getWriter();
        pw.println(json.toJSONString());

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String kcal = req.getParameter("kcal");
        String proteins = req.getParameter("proteins");
        String fats = req.getParameter("fats");
        String carbohydrates = req.getParameter("carbohydrates");

        int id = 0;
        String idString = req.getParameter("id");
        if (null != idString && idString.length() > 0) {
            id = Integer.parseInt(idString);
        }

        Product product = new Product();

        try {
            ProductDAOImpl productDAO = new ProductDAOImpl();
            product = productDAO.getProductById(id);
            product.setName(name);
            product.setKcal(Double.parseDouble(kcal));
            product.setProteins(Double.parseDouble(proteins));
            product.setFats(Double.parseDouble(fats));
            product.setCarbohydrates(Double.parseDouble(carbohydrates));

            productDAO.updateProduct(product);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка запроса", JOptionPane.OK_OPTION);
        }

        JSONObject json = new JSONObject();
        json.put("products", JsonMap.productToJson(product));
        PrintWriter pw = resp.getWriter();
        pw.println(json.toJSONString());

    }
}
