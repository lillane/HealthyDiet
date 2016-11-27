package com.healthydiet.interfaces;

import com.healthydiet.entity.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Яна on 27.10.2016.
 */
public interface CategoryDAO {
    public List<Category> getCategories() throws SQLException;
    public Category getCategoryById(int id) throws SQLException;
}
