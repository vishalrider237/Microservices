package com.user.service.external.service;

import com.user.service.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @PostMapping("/ratings")
    public Rating createRating(Rating values);

    @PutMapping("/ratings/{ratingsId}")
    public Rating updateRating(@PathVariable String ratingsId, Rating values);

    @DeleteMapping("/ratings/{ratingsId}")
    public Rating deleteRating(@PathVariable String ratingsId);
}
