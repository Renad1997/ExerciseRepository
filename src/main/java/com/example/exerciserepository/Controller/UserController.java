package com.example.exerciserepository.Controller;

import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Repository.UserRepository;
import com.example.exerciserepository.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser() {
        return ResponseEntity.status(200).body(userService.getUser());
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user , Errors errors ) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid @RequestBody User user, Errors errors ){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUser(id,user);

        return ResponseEntity.status(200).body("User Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("User Deleted");

    }

    @GetMapping("/get/check/{username}/{password}")
    public ResponseEntity checkUsernameAndPassword(@PathVariable String username,@PathVariable String password){
        return ResponseEntity.status(200).body(userService.checkUsernameAndPassword(username,password));
    }
    @GetMapping("/get/email/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body(userService.getUserByEmail(email));
    }

    @GetMapping("/get/role/{role}")
    public ResponseEntity getUserByRole(@PathVariable String role){
    List<User> u = userService.getUserByRole(role);
    if(u==null){
        return ResponseEntity.status(400).body("User Not Found");
    }
    return ResponseEntity.status(200).body(u);
    }

   @GetMapping("/get/age/{age}")
    public ResponseEntity getUserByAge(@PathVariable int age){
        List<User> u = userService.getUserByAge(age);
        return ResponseEntity.status(200).body(u);

    }

}
