package com.disney.studios.service;


import com.disney.studios.models.Dog;
import com.disney.studios.models.Favorite;
import com.disney.studios.models.User;

import java.util.List;

public interface FavoriteService {

	public Favorite addFavorite(User user , Dog dog);
	public Favorite findByUserIdDogId(User user , Dog dog);
	public String unFavorite(User user , Dog dog) throws Exception ;
    public List<Long> getAll();
}
