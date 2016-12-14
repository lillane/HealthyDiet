package com.healthydiet.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "recipe_types")
public class RecipeType extends BaseModel{

    @Column(name="name")
    private String name;

    @OneToMany(fetch= FetchType.LAZY, mappedBy = "recipe_type", cascade = CascadeType.ALL)
    private Set<Recipe> recipes;

    public RecipeType(int id, String name){
        super.setId(id);
        this.name = name;
    }

    public RecipeType(){}

    @Override
    public void setId(int id) {
        super.setId(id);
    }
    @Override
    public int getId() {
        return super.getId();
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
    public Set<Recipe> getRecipes() {
        return recipes;
    }

}
