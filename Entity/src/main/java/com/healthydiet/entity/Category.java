package com.healthydiet.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Яна on 27.10.2016.
 */
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(fetch= FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Recipe> recipes;

    public Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Category(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}
