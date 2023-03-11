package com.scheronlini.apiRestfulmongodb.resource;

import com.scheronlini.apiRestfulmongodb.domain.User;
import com.scheronlini.apiRestfulmongodb.dto.UserDTO;
import com.scheronlini.apiRestfulmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> users = userService.findAll();
        List<UserDTO> usersDTO = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usersDTO);
    }
        @GetMapping(value = "/{id}")
        public ResponseEntity <UserDTO> findById(@PathVariable String id){
        UserDTO userDTO = new UserDTO(userService.findById(id));
        return ResponseEntity.ok().body(userDTO);
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
