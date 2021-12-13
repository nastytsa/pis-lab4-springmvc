package com.example.lab4.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long id;
    private String login;
    private String password;
    @ManyToOne
    @JoinColumn(name="role_id", referencedColumnName = "role_id")
    private Role role;
}
