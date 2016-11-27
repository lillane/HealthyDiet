package com.healthydiet.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Яна on 27.10.2016.
 */

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    // Нормы на 100г. продукта:
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getKcal() {
        return kcal;
    }

    public double getProteins() {
        return proteins;
    }

    public double getFats() {
        return fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }
}
