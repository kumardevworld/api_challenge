package com.disney.studios.controller;

import com.disney.studios.models.Dog;
import com.disney.studios.models.Favorite;
import com.disney.studios.models.User;
import com.disney.studios.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/appfavorites/v1/favorites")
public class AppFavoriteController {

    @Autowired
    FavoriteService favoriteService;

    @RequestMapping(value = "/dogs/{dogId}",
            method = RequestMethod.POST)
    public Favorite makeFavorite(@PathVariable("dogId") String dogId,
                                 @RequestBody User user) {

        Dog dog = new Dog();
        dog.setId(Long.valueOf(dogId));
        Favorite newlyFavorited = this.favoriteService.addFavorite(user, dog);
        return newlyFavorited;
    }


    @RequestMapping(value = "/dogs/{dogId}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public void unFavorite(@PathVariable("dogId") String dogId,
                           @RequestBody User user) {

        Dog dog = new Dog();
        dog.setId(Long.valueOf(dogId));
        String unFavorited = null;
        try {
            unFavorited = this.favoriteService.unFavorite(user, dog);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
