package com.healthydiet.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "recipes")
public @Data class Recipe extends BaseModel{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private RecipeType recipeType;

    @ManyToMany
    @JoinTable(name = "recipe_to_product",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

//    @Override
//    public int getId() {
//        return super.getId();
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getName() {
//        return name;
//    }
//
//    public void setRecipeType(RecipeType recipeType) {
//        this.recipeType = recipeType;
//    }
//    public RecipeType getRecipeType() {
//        return recipeType;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//    public String getDescription() {
//        return description;
//    }
//
//    public void setProducts(Set<Product> products) {
//        this.products = products;
//    }
//    public Set<Product> getProducts() {
//        return products;
//    }

}
