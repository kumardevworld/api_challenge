package com.disney.studios.service;

import com.disney.studios.jpa.DogRepository;
import com.disney.studios.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@ComponentScan
@Service
public class DogServiceImpl implements  DogService{

    @Autowired
    private DogRepository dogRepository;



    @Override
    public Dog createDog(Dog dog) {
        return dogRepository.save(dog);
    }

    @Override
    public Dog getDog(long id) {
        return dogRepository.findOne(id);
    }

    @Override
    public List<Map.Entry<String, List<Dog>>> getAllDogs() {
        Iterable<Dog> listOfDogs = dogRepository.findAllByOrderByBreed();
        List<Dog> generalList = new ArrayList<>();
        listOfDogs.forEach(generalList::add);

        List<Dog> orderedList = new ArrayList<Dog>();
        orderedList.addAll(generalList);

        Stream<Map.Entry<String,List<Dog>>> sorted =
                StreamSupport.stream(orderedList.spliterator(), false).
                        collect(Collectors.groupingBy(Dog::getBreed,Collectors.toList())).entrySet().stream();


        List <Map.Entry<String,List<Dog>>> sortedList = new ArrayList<>();
        sorted.forEach(entry -> sortedList.add(entry));

        return sortedList;
    }

    @Override
    public List<Map.Entry<String, List<Dog>>> getAllDogsByBreed(String breed) {
        Iterable<Dog> listOfDogs = dogRepository.findDogsByBreedIgnoreCaseContaining(breed);

        List<Dog> generalListByBreed = new ArrayList<>();
        listOfDogs.forEach(generalListByBreed::add);

        List<Dog> orderedList = new ArrayList<>();
        orderedList.addAll(generalListByBreed);
        Stream<Map.Entry<String,List<Dog>>> sorted =
                StreamSupport.stream(orderedList.spliterator(), false).
                        collect(Collectors.groupingBy(Dog::getBreed,Collectors.toList())).entrySet().stream();

        List <Map.Entry<String,List<Dog>>> sortedList = new ArrayList<>();
        sorted.forEach(entry -> sortedList.add(entry));
        return sortedList;
    }
}
