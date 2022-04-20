package com.disney.studios.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "dog")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dog {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(name="breed")
    String breed;

   
    @Column()
    private String imageUrl;

}
