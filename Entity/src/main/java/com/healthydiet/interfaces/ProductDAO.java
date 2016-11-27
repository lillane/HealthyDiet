package com.healthydiet.interfaces;

import com.healthydiet.entity.Product;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Яна on 27.10.2016.
 */
public interface ProductDAO {
    public void addProduct(Product product) throws SQLException;
    public void updateProduct(Product product) throws SQLException;
    public Product getProductById(int id) throws SQLException;
    public Product getProductByName(String name) throws SQLException;
    public List<Product> getProducts() throws SQLException;
    public List<Product> getProducts(List id) throws SQLException;
    public void deleteRecipeById(int productId) throws SQLException;
}
