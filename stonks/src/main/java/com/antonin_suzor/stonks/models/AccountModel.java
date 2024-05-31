package com.antonin_suzor.stonks.models;

import java.util.ArrayList;
import java.util.List;

public class AccountModel {
    public int id;
    public String username;

    private static int maxId = 0;
    public static List<AccountModel> all = new ArrayList<>();
    public static AccountModel findById(String id) {
        return findById(Integer.parseInt(id));
    }
    public static AccountModel findById(int id) {
        return all.stream().filter((account) -> (account.id == id)).findAny().orElse(null);
    }

    public AccountModel(String username) {
        this(++maxId, username);
    }
    private AccountModel(int id, String username) {
        this.id = id;
        this.username = username;
        all.add(this);
    }
}
