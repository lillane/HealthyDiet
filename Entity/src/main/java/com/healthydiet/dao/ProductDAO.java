package com.healthydiet.dao;

import com.healthydiet.entity.Product;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by Яна on 27.10.2016.
 */
public interface ProductDAO {
    public void addProduct(Product product) throws SQLException;
    public void updateProduct(Product product) throws SQLException;
    public Product getProductById(int id) throws SQLException;
    public Product getProductByName(String name) throws SQLException;
    public Set<Product> getProducts() throws SQLException;
    public Set<Product> getProducts(Set id) throws SQLException;
    public void deleteRecipeById(int productId) throws SQLException;
}
