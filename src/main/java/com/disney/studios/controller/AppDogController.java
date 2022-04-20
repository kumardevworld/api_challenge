package com.disney.studios.controller;

import com.disney.studios.models.Dog;
import com.disney.studios.service.DogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/appdog/v1/dogs")
public class AppDogController {

    @Autowired
    private DogServiceImpl dogService;

    /**
     *  GET method
     *
     * @return Key as breed and list of dogs.
     */
    @RequestMapping(value = "/breeds",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Map.Entry<String, List<Dog>>> getAllDog() {
        return this.dogService.getAllDogs();
    }


    /**
     * GET method
     * @param breed
     * @return Returns a particular breed list of dogs.
     */
    @RequestMapping(value = "/breeds/{breed}",
            method = RequestMethod.GET,  produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Map.Entry<String,List<Dog>>> getAllDogByBreed(
            @PathVariable("breed") String breed) {
        return this.dogService.getAllDogsByBreed(breed);
    }

}
