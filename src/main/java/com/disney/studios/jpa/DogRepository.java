package com.disney.studios.jpa;

import com.disney.studios.models.Dog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends PagingAndSortingRepository<Dog,Long> {
    Iterable<Dog> findAllByOrderByBreed();
    Iterable<Dog> findDogsByBreedIgnoreCaseContaining(@Param("breed") String breed);

}
