package com.healthydiet.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "products")
public @Data class Product extends BaseModel {

    @Column(name="name")
    private String name;

    @Column(name="kcal")
    private double kcal;

    @Column(name="proteins")
    private double proteins;

    @Column(name="fats")
    private double fats;

    @Column(name="carbohydrates")
    private double carbohydrates;

   /* @ManyToMany
    @JoinTable(name = "recipe_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id"))
    private Set<Recipe> recipes = new HashSet<Recipe>(); */

    public Product (int id, String name, double kcal, double proteins, double fats, double carbohydrates){
        this.id = id;
        this.name = name;
        this.kcal = kcal;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public Product (){}
}
