package com.healthydiet.entity;

import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "recipe_types")
public @Data class RecipeType extends BaseModel{

    @Column(name="name")
    private String name;

    @OneToMany(fetch= FetchType.LAZY, mappedBy = "recipe_type", cascade = CascadeType.ALL)
    private Set<Recipe> recipes;

    public RecipeType(int id, String name){
        setId(id);
        setName(name);
    }

    public RecipeType(){}
}
