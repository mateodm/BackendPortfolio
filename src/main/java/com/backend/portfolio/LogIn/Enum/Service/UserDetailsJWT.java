
package com.backend.portfolio.LogIn.Enum.Service;

import com.backend.portfolio.LogIn.Enum.Entity.User;
import com.backend.portfolio.LogIn.Enum.Entity.UserP;
import java.nio.file.attribute.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
/**
 *
 * @author Mateo De Mari
 */
public class UserDetailsJWT implements UserDetailsService{
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.getByNameUser(name).get();
        return UserP.build(user);
    }
}
