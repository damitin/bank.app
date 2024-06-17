package com.example.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "bank", name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne()
//    @JoinColumn(name = "user_id")
//    User user;
    @Column(name = "money_amount")
    private int moneyAmount;

    @Column(name = "user_id")
    private int user_id;


    public Account() {
    }

    public Account(int id, int moneyAmount, int user_id) {
        this.id = id;
        this.moneyAmount = moneyAmount;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }
}
