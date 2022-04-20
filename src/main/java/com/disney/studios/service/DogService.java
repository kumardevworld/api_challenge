package com.disney.studios.service;

import com.disney.studios.models.Dog;

import java.util.List;
import java.util.Map;


public interface DogService {

    public Dog createDog(Dog dog);
    public Dog getDog(long id);

    public List<Map.Entry<String, List<Dog>>> getAllDogs();

    public List<Map.Entry<String, List<Dog>>> getAllDogsByBreed(String breed);

}
