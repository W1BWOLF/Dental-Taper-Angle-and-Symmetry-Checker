package ma.projet.services;


import ma.projet.entities.User;
import ma.projet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User create(User o) {
        // TODO Auto-generated method stub
        return userRepository.save(o);
    }

    public boolean delete(User o) {
        // TODO Auto-generated method stub
        try {
            userRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;		}
    }

    public User update(User o) {
        // TODO Auto-generated method stub
        return userRepository.save(o);
    }

    public List<User> findAll() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }



    public User findById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).orElse(null);
    }


}