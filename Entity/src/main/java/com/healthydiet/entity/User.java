package com.healthydiet.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Яна on 27.10.2016.
 */

@Entity
@Table(name="user")
public class User {
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private int id;

    /**
     * Методы для возврата имени и пароля пользователя
     * @return
     */

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public int getId(){
        return id;
    }

    public User()
    {
    }

    public User(String username, String password, int id){
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setId(int id){
        this.id = id;
    }

}
