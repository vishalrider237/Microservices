package com.user.service.service;

import com.user.service.entity.Hotel;
import com.user.service.entity.Rating;
import com.user.service.entity.User;
import com.user.service.exception.ResourceNotFound;
import com.user.service.external.service.HotelService;
import com.user.service.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelService hotelService;
    private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User saveUser(User user) {
        String randomUserId= UUID.randomUUID().toString();
        user.setId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> user = userRepository.findAll();
        return user;
    }

    @Override
    public User getUser(String userId) {
          User user= userRepository.findById(userId).orElseThrow(()->new ResourceNotFound("User with given id not found "+userId));
          //
        Rating []list=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getId(), Rating[].class);
        logger.info("{} ",list);
        List<Rating> rating1 = Arrays.asList(list);
        List<Rating>ratingList=  rating1.stream().map(rating -> {
             // Call hotel service

          //   ResponseEntity<Hotel> f = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
             Hotel hotel = hotelService.getHotel(rating.getHotelId());
           //  logger.info("response status code:{} ",f.getStatusCode());
             rating.setHotel(hotel);
             return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
          return user;
    }
}
