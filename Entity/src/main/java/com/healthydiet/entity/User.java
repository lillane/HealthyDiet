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
        super.setId(id);
    }

    public User(){}

    @Override
    public void setId(int id) {
        super.setId(id);
    }
    @Override
    public int getId() {
        return super.getId();
    }

    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }


}
