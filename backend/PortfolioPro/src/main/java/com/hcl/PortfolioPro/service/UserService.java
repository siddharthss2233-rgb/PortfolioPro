package com.hcl.PortfolioPro.service;

import com.hcl.PortfolioPro.model.User;
import com.hcl.PortfolioPro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Addanewuser
    public User save(User user) {
        return userRepository.save(user);
    }

    // Getallusers
    public List<User> fetchUsers() {
        return userRepository.findAll();
    }

    // GetauserusingID
    public Optional<User> fetchUserById(Long id) {
        return userRepository.findById(id);
    }

    // updateuserdetails
    public User updateUser(Long id, User user) {

        Optional<User> oldUser = userRepository.findById(id);

        if (oldUser.isPresent()) {

            User existingUser = oldUser.get();

            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());

            return userRepository.save(existingUser);
        }

        return null;
    }

    // Deleteauser
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}