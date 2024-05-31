package com.antonin_suzor.stonks.services;

import java.util.List;

import org.springframework.lang.NonNull;

import com.antonin_suzor.stonks.entities.AccountEntity;
import com.antonin_suzor.stonks.models.AccountModel;

public class UserService {
    public static List<AccountEntity> getAllUsers() {
        return AccountModel.all.stream().map((account) -> {
            return convertToEntity(account);
        }).toList();
    }
    public static AccountEntity findById(String id) {
        return convertToEntity(AccountModel.findById(id));
    }

    public static AccountEntity createUser(String username) {
        return convertToEntity(new AccountModel(username));
    }
    public static AccountEntity createUser(String username, @NonNull String password) {
        return convertToEntity(new AccountModel(username, password));
    }

    private static AccountEntity convertToEntity(AccountModel model) {
        AccountEntity entity = new AccountEntity();
        entity.setId(model.getId());
        entity.setUsername(model.getUsername());
        entity.setCreatedAt(model.getCreatedAt());
        return entity;
    }
}
