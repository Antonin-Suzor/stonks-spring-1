package com.antonin_suzor.stonks.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class AccountModel {
    @Getter
    private int id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;
    @Getter
    private Date createdAt;

    private static int maxId = 0;
    public static List<AccountModel> all = new ArrayList<>();
    public static AccountModel findById(String id) {
        return findById(Integer.parseInt(id));
    }
    public static AccountModel findById(int id) {
        return all.stream().filter((account) -> (account.id == id)).findAny().orElse(null);
    }

    public AccountModel(String username) {
        this(++maxId, username, "");
    }
    public AccountModel(String username, String password) {
        this(++maxId, username, password);
    }
    private AccountModel(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createdAt = new Date();
        all.add(this);
    }
}
