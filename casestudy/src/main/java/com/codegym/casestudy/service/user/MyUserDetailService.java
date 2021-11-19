package com.codegym.casestudy.service.user;

import com.codegym.casestudy.model.authen.User;
import com.codegym.casestudy.repository.employee.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class MyUserDetailService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void save(User user) {
        iUserRepository.save(user);

    }

    @Override
    public User findByUserName(String username) {
        return iUserRepository.findByUsername(username);
    }

    @Override
    public User findById(Integer id) {
        return iUserRepository.findById(id).get();
    }

    @Override
    public void update(User user) {
        iUserRepository.save(user);

    }

    @Override
    public List<User> searchByUserName(String usename) {
        return iUserRepository.findByUsernameContaining(usename);
    }


}




   /* @Autowired
    private IUserRepository iuserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> user = iuserRepository.findByUserNameContaining(username);

        if (user == null) {
            throw new UsernameNotFoundException("username not found" + username);
        }
        return new UserRole(user);

    }*/

