package com.antonin_suzor.stonks.entities;

import java.util.Date;

import lombok.Data;

@Data
public class AccountEntity {
    public int id;
    public String username;
    public Date createdAt;
}
