/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.Validate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sawbonadev.cafe.model.person.User;
import sawbonadev.cafe.model.users.Role;

/**
 *
 * @author sawbona
 */
public class BasicUserDetails implements UserDetails {

    private final User user;
    
    private final List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

    public BasicUserDetails(User user) {
        
        Validate.notNull(user);
        
        this.user = user == null ? new User() : user;
        final List<Role> roles = this.user.getRoles();
        for (final Role role : roles) {
            grantedAuthorities.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return role.getName();
                }
            });
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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

    @Override
    public int hashCode() {
        return user.getEmail().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BasicUserDetails other = (BasicUserDetails) obj;
        return Objects.equals(this.user.getEmail(), other.user.getEmail());
    }
    
    

}
