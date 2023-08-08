package com.ratingservice.repository;

import com.ratingservice.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {
    List<Rating>findByUserId(String userId);
    List<Rating>findByHotelId(String hotelId);
}
