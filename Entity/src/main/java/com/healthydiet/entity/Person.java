package com.healthydiet.entity;

import javax.persistence.*;

@Entity
@Table(name="person")
public class Person {

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="middlename")
    private String middleName;

//    TODO make the validation email
    @Column(name="email")
    private String email;

//    TODO make the validation and verification of numbers unique
    @Column(name="phonenumber")
    private String phoneNumber;

    public Person(){}

}
