package com.healthydiet.dao;

import com.healthydiet.entity.RecipeType;
import java.sql.SQLException;
import java.util.*;

public interface RecipeTypeDAO {

    public RecipeType getRecipeTypeById(int id) throws SQLException;

    public Set<RecipeType> getRecipeTypes() throws SQLException;

}
