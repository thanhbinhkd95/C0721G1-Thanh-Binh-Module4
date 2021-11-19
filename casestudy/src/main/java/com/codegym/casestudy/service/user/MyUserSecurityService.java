package com.codegym.casestudy.service.user;

import com.codegym.casestudy.model.authen.User;
import com.codegym.casestudy.model.authen.UserDetail;
import com.codegym.casestudy.repository.employee.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserSecurityService implements UserDetailsService {
    @Autowired
    private IUserRepository iuserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iuserRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("username not found" + username);
        }
        return new UserDetail(user);
    }
}

