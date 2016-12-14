package com.healthydiet.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends BaseModel {

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
        super.setId(id);
        this.name = name;
        this.kcal = kcal;
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public Product (){}

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

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }
    public double getProteins() {
        return proteins;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }
    public double getKcal() {
        return kcal;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }
    public double getFats() {
        return fats;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
    public double getCarbohydrates() {
        return carbohydrates;
    }

}
