package com.healthydiet.utils;


import com.healthydiet.entity.Category;
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
        obj.put("category", categoryToJson(recipe.getCategory()));
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

    public static JSONObject categoryToJson(Category category) {
        JSONObject obj = new JSONObject();
        obj.put("id", category.getId());
        obj.put("name", category.getName());

        return obj;
    }

    public static JSONArray categoryToJson(Collection<Category> categoryList) {
        JSONArray list = new JSONArray();
        for (Category category : categoryList) {
            list.add(categoryToJson(category));
        }
        return list;
    }
}
