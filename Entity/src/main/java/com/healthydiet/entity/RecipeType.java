package com.healthydiet.entity;

import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "recipeTypes")
public @Data class RecipeType extends BaseModel{

    @Column(name="name")
    private String name;

    @OneToMany(fetch= FetchType.LAZY, mappedBy = "recipeType", cascade = CascadeType.ALL)
    private Set<Recipe> recipes;

    public RecipeType(int id, String name){
        setId(id);
        setName(name);
    }

    public RecipeType(){}
}
