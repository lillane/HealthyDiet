package com.healthydiet.dao;

import com.healthydiet.entity.Recipe;

import java.sql.SQLException;
import java.util.List;


public interface RecipeDAO {
    public void addRecipe(Recipe recipe) throws SQLException;
    public void updateRecipe(Recipe recipe) throws SQLException;
    public Recipe getRecipeById(int id) throws SQLException;
    public List<Recipe> findRecipesByName(String name) throws SQLException;
    public List<Recipe> getRecipes(int categoryId) throws SQLException;
    public void deleteRecipeById(int recipeId) throws SQLException;
}
