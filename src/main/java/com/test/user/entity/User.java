package com.test.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends Audit {
    @Id
    @GeneratedValue
    private UUID id;
    private String userName;
    private String fullName;
    private String phoneNumber;
}
