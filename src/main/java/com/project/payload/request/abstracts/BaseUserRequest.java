package com.project.payload.request.abstracts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseUserRequest  extends AbstractUserRequest{

    @NotNull(message = "Please enter your password")
    @Size(min = 8, max = 60, message = "Password must be between 8 and 60 characters")
    private String password;

    private Boolean builtIn = false;

}
