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
@Table(name = "favorite")
public class Favorite {
	
    @Id
    @GeneratedValue()
    private Long id;

    @Column(nullable = false)
    private Long userId;

    public Favorite(Long userId, Long dogId) {
        this.userId = userId;
        this.dogId = dogId;
    }

    @Column(nullable = false)
    private Long dogId;
}
