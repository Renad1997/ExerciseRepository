package com.example.exerciserepository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should be not empty")
    @Size(min = 4,message = "name must be more than 4 characters")
    private String name;

    @NotEmpty(message = "username should be not empty")
    @Size(min = 4,message = "name must be more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;

    @NotEmpty(message = "password should be not Empty!")
    @Pattern(regexp = "(^(?:(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*)[^\\s]{8,}$)",message = "password must contain 8 character and digits")
    @Column(columnDefinition = "varchar(15) not null")
    private String password;

    @NotEmpty(message = "email should be not empty!")
    @Email(message = "Email must be valid email")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotEmpty(message = "role should be not empty!")
    @Pattern(regexp="^(user|admin)$",message = "Role must to be user or admin")
  //@Column(columnDefinition = "varchar(10) check(role='user' or role='admin')")
    private String role;

    @NotNull(message = "age should be not null")
    @Positive(message = " age must be a positive number")
    @Column(columnDefinition = "int not null")
    private int age;


}
