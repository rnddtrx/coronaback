package be.ipam.coronaback.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUserDetails implements UserDetails {

  private static final long serialVersionUID = 5155720064139820502L;

  private final String id;
  private final String username;
  private final String password;
  private final Collection<? extends GrantedAuthority> authorities;

  public JwtUserDetails(String string, String username, String password, String role) {
    this.id = string;
    this.username = username;
    this.password = password;

    List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
    
    String[] roles = role.split(",");
    for(String r:roles) {
    	authorities.add(new SimpleGrantedAuthority(r));
    }

    this.authorities = authorities;
  }

  @JsonIgnore
  public String getId() {
    return id;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}


