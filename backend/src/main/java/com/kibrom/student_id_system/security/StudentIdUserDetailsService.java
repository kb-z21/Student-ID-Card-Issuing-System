package com.kibrom.student_id_system.security;


import com.kibrom.student_id_system.entity.User;
import com.kibrom.student_id_system.repository.UserRepository;


import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;



import java.util.List;



@Service
public class StudentIdUserDetailsService
        implements UserDetailsService {



    private final UserRepository userRepository;



    public StudentIdUserDetailsService(
            UserRepository userRepository
    ){

        this.userRepository = userRepository;

    }




    @Override
    public UserDetails loadUserByUsername(
            String username
    ) throws UsernameNotFoundException {



        User user =
                userRepository.findByUsername(username)
                        .orElseThrow(
                                () -> new UsernameNotFoundException(
                                        "User not found"
                                )
                        );



        return new org.springframework.security.core.userdetails.User(

                user.getUsername(),

                user.getPassword(),


                List.of(
                        new SimpleGrantedAuthority(
                                "ROLE_" + user.getRole().name()
                        )
                )

        );

    }

}