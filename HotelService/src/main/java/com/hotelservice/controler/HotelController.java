package com.hotelservice.controler;

import com.hotelservice.entity.Hotel;
import com.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
  //  @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }
   // @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{hotelid}")
    public ResponseEntity<Hotel> getSingle(@PathVariable String hotelid){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getSingle(hotelid));
    }
  //  @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<Hotel>>getAll(){
        return ResponseEntity.ok(hotelService.getAll());
    }
}
