package com.example.bank.model;

import com.example.bank.entity.User;

public class AccountDTO {
    private int id;
    private int moneyAmount;
    private int user_id;

    public AccountDTO(int id, int moneyAmount, int user_id) {
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

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
