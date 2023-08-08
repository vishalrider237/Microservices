package com.user.service;


import com.user.service.entity.Rating;
import com.user.service.external.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Configuration
public class UserServiceApplication {
    @Autowired
    private RatingService ratingService;
   /* @Autowired
    private ClientRegistrationRepository registrationRepository;*/
  //  @Autowired
 //   private OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate;
    }
   /* @Bean
    public OAuth2AuthorizedClientManager manager(ClientRegistrationRepository clientRegistrationRepository, OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository){
        DefaultOAuth2AuthorizedClientManager defaultOAuth2AuthorizedClientManager=new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository,oAuth2AuthorizedClientRepository);
        OAuth2AuthorizedClientProvider provider= OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build();
        defaultOAuth2AuthorizedClientManager.setAuthorizedClientProvider(provider);
        return defaultOAuth2AuthorizedClientManager;*/


  // @Test
   /* void createRating(){
        Rating rating=Rating.builder().ratings(8).userId("").hotelId("").feedback("This is created using feign client").build();
      Rating rating1=  ratingService.createRating(rating);
        System.out.println("New Rating Generated "+rating1);
    }*/
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
