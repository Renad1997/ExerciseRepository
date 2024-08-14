package com.example.exerciserepository.Repository;

import com.example.exerciserepository.Model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    User findUserByUsernameAndPassword(String username, String password);

    User findUserByEmail(String email);

    List<User> findUserByRole(String role);

    List<User> findUserByAgeGreaterThan(int age);







}
