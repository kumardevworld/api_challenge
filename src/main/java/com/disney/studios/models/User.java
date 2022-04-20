package com.disney.studios.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue()
    private Long id;
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}

