package com.antonin_suzor.stonks.dtos.requests;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String password;
}
