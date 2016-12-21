package com.healthydiet.utils;


import com.healthydiet.entity.RecipeType;
import com.healthydiet.entity.Product;
import com.healthydiet.entity.Recipe;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Collection;

public class JsonMap {

    public static JSONObject productToJson(Product product) {
        JSONObject obj = new JSONObject();
        obj.put("id", product.getId());
        obj.put("name", product.getName());
        obj.put("kcal", product.getKcal());
        obj.put("carbohydrates", product.getCarbohydrates());
        obj.put("fats", product.getFats());
        obj.put("proteins", product.getKcal());

        return obj;
    }

    public static JSONArray productToJson(Collection<Product> products) {
        JSONArray list = new JSONArray();
        for (Product product: products) {
            list.add(productToJson(product));
        }
        return list;
    }

    public static JSONObject recipeToJson(Recipe recipe) {
        JSONObject obj = new JSONObject();
        obj.put("id", recipe.getId());
        obj.put("name", recipe.getName());
        obj.put("recipeType", recipeTypeToJson(recipe.getRecipeType()));
        obj.put("description", recipe.getDescription());

        obj.put("products", productToJson(recipe.getProducts()));

        return obj;
    }

    public static JSONArray recipeToJson(Collection<Recipe> recipes) {
        JSONArray list = new JSONArray();
        for (Recipe recipe: recipes) {
            list.add(recipeToJson(recipe));
        }
        return list;
    }

    public static JSONObject recipeTypeToJson(RecipeType recipeType) {
        JSONObject obj = new JSONObject();
        obj.put("id", recipeType.getId());
        obj.put("name", recipeType.getName());

        return obj;
    }

    public static JSONArray recipeTypeToJson(Collection<RecipeType> recipeTypeList) {
        JSONArray list = new JSONArray();
        for (RecipeType recipeType : recipeTypeList) {
            list.add(recipeTypeToJson(recipeType));
        }
        return list;
    }
}
