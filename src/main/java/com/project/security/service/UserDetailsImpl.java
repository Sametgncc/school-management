package com.project.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {


    private Long id;
    private String username;
    private String name;
    private Boolean isAdvisor;

    @JsonIgnore
    private String password;
    private String ssn;
    private Collection<? extends GrantedAuthority> authorities;

    // parametreli constructor
    // security nin analayacagi userDetails turune cevirsin
    public UserDetailsImpl(Long id, String username, String name, Boolean isAdvisor, String password, String ssn, String role) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.isAdvisor = isAdvisor;
        this.password = password;
        this.ssn = ssn;
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role));
        this.authorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // elemizdeki userdetails objesi ile baska bir obje ayni mi diye kiyaslama yapiyoruz equals method u ile
    public boolean equals(Object o) {
        if(this == o) return true;

        if (o == null || getClass() != o.getClass())  return false;

        UserDetailsImpl user = (UserDetailsImpl) o;
        return id.equals(user.id);
    }
}
