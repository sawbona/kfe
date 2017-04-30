/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.cafe.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import sawbonadev.cafe.model.person.User;
import sawbonadev.cafe.repository.UserDao;

/**
 *
 * @author sawbona
 */
@Repository
public class UsersAuthenticationProvider implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        final User user = userDao.findByEmail(string);
        return user == null ? null : new BasicUserDetails(user);
    }
    
}
