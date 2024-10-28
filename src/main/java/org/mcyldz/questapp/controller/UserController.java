package org.mcyldz.questapp.controller;

import org.mcyldz.questapp.model.User;
import org.mcyldz.questapp.response.UserResponse;
import org.mcyldz.questapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserResponse getOneUser(@PathVariable Integer userId){
        User user = userService.getOneUserById(userId);
        if(user == null) {
            return null;
        }
        return new UserResponse(user);
    }

    @PostMapping
    public User createOneUser(@RequestBody User newUser){
        return userService.saveOneUser(newUser);
    }

    @PutMapping("/{userId}")
    public User updateOneUser(@PathVariable Integer userId, @RequestBody User newUser){
        return userService.updateOneUser(userId, newUser);
    }

    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable Integer userId){
        userService.deleteById(userId);
    }

    @GetMapping("/activity/{userId}")
    public List<Object> getUserActivity(@PathVariable Integer userId) {
        return userService.getUserActivity(userId);
    }

}
