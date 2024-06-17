package com.example.bank.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "bank", name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "login", unique = true)
    private String login;

//    @OneToMany(cascade = CascadeType.REMOVE)
//    @JoinColumn(name = "user_id", nullable = false)
//    private Set<Account> accountSet;

    public User() {
    }

    public User(int id, String login) {
        this.id = id;
        this.login = login;
//        this.accountSet = accountSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

//    public Set<Account> getAccountSet() {
//        return accountSet;
//    }
//
//    public void setAccountSet(Set<Account> accountSet) {
//        this.accountSet = accountSet;
//    }
}
