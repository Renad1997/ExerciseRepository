package com.example.exerciserepository.Service;

import com.example.exerciserepository.Api.ApiException;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

  public List<User> getUser() {
      return userRepository.findAll();
  }

  public void addUser(User user) {
      userRepository.save(user);
  }

  public void updateUser(Integer id ,User user) {
      User u = userRepository.findUserById(id);
   if(u==null){
       throw new ApiException("User not found");
   }
   u.setName(user.getName());
   u.setUsername(user.getUsername());
   u.setPassword(user.getPassword());
   u.setEmail(user.getEmail());
   u.setRole(user.getRole());
   u.setAge(user.getAge());
   userRepository.save(u);
  }

  public void deleteUser(Integer id) {
      User u = userRepository.findUserById(id);
      if(u==null){
          throw new ApiException("User not found");
      }
      userRepository.delete(u);
  }

   public User checkUsernameAndPassword(String username, String password) {
    User u = userRepository.findUserByUsernameAndPassword(username, password);
    if(u==null){
        throw new ApiException("User not found");
    }
    return u;
   }

   public User getUserByEmail(String email) {
      User u = userRepository.findUserByEmail(email);
      if(u==null){
          throw new ApiException("User not found");
      }
      return u;
   }

   public List<User> getUserByRole(String role) {
   List<User> u = userRepository.findUserByRole(role);
   if(u.isEmpty()){
       return null;
   }
   return u;
   }

   public List<User> getUserByAge(int age) {
      List<User> u = userRepository.findUserByAgeGreaterThan(age);
      if(u==null){
          return null;
      }
      return u;
   }

}
