package com.disney.studios.jpa;

import com.disney.studios.models.Favorite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Long> {
	
	Favorite findByUserIdAndDogId (Long userId, Long dogId);
	
}
