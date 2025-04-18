package com.project.payload.request.authentication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginRequest {

    @NotNull(message = "Username must be not empty")
    private String username;
    @NotNull(message = "Password must be not empty")
    private String password;

}
