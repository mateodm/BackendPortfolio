
package com.backend.portfolio.LogIn.Enum.Controller;

import com.backend.portfolio.LogIn.Enum.DTO.JwtDto;
import com.backend.portfolio.LogIn.Enum.DTO.NewUser;
import com.backend.portfolio.LogIn.Enum.Entity.Rol;
import com.backend.portfolio.LogIn.Enum.Entity.RolName;
import com.backend.portfolio.LogIn.Enum.Entity.User;
import com.backend.portfolio.LogIn.Enum.Security.JWT.JwtProvider;
import com.backend.portfolio.LogIn.Enum.Service.RolService;
import com.backend.portfolio.LogIn.Enum.Service.UserService;
import jakarta.validation.Valid;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins ="https://fir-portfolio12001324.web.app")
public class Controller {
    @Autowired RolService rolService;
    @Autowired JwtProvider jwtProvider;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired AuthenticationManager authenticationManager;
    @Autowired UserService userService;
    @PostMapping("/new")
    
    
    public ResponseEntity<?> neww(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Los campos ingresados no son los correctos"),HttpStatus.BAD_REQUEST);
        if(userService.existsByNameUser(newUser.getName()))
            return new ResponseEntity(new Mensaje("El nombre ya esta en uso"), HttpStatus.BAD_REQUEST);
            User user = new User(newUser.getName(), passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
            user.setRoles(roles);
            userService.save(user);
            return new ResponseEntity(new Mensaje("Usuario guardado"), HttpStatus.CREATED);           
     }
    
    
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Mensaje("Faltan campos"),HttpStatus.BAD_REQUEST);
        
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        loginUser.getName(), loginUser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String jwt = jwtProvider.generateToken(authentication);
        
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    }
