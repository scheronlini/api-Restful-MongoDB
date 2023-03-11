package com.scheronlini.apiRestfulmongodb.services;

import com.scheronlini.apiRestfulmongodb.domain.User;
import com.scheronlini.apiRestfulmongodb.dto.UserDTO;
import com.scheronlini.apiRestfulmongodb.repository.UserRepository;
import com.scheronlini.apiRestfulmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    public User update(User newUser) {
        User userData = findById(newUser.getId());
        updateData(newUser, userData);
        return userRepository.save(newUser);
    }

    public User fromDTO(UserDTO userDTO) {
        User user = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
        return user;
    }

    public void updateData(User newUser, User userData) {
        userData.setEmail(newUser.getEmail());
        userData.setName(newUser.getName());
    }
}
