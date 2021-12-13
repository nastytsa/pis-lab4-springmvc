package com.example.lab4.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY )
    private Long role_id;
    @Enumerated(EnumType.STRING)
    private RoleEnum role_name;
}
