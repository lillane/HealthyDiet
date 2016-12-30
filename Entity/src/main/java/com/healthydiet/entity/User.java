package com.healthydiet.entity;


import javax.persistence.*;

@Entity
@Table(name="user")
public class User extends BaseModel {

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public User(String username, String password, int id){
        this.username = username;
        this.password = password;
        setId(id);
    }

    public User(){}
}
