package com.camp.havenfort_dev.controllers;

import com.camp.havenfort_dev.entities.*;
import com.camp.havenfort_dev.services.*;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@AllArgsConstructor
public class Controller {
    IReservationService iReservationService;
    IEventService iEventService;
    ICenterOfCampService iCenterOfCampService;
    ICampsiteService iCampsiteService;
    IActivityService iActivityService;


    @PostMapping("/AddReservation")
    public Reservation addReservation(@RequestBody Reservation r){
        return iReservationService.addReservation(r);
    }

    @GetMapping("/allReservation")
    public ResponseEntity<List<Reservation>> getAllReservation (){
        List<Reservation> reservations = iReservationService.findAllReservation();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PutMapping("/updateReservation")
    public ResponseEntity<Reservation> updateEmployee(@RequestBody Reservation reservation){
        Reservation updateReservation = iReservationService.updateReservation(reservation);
        return new ResponseEntity<>(updateReservation, HttpStatus.OK);
    }
    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        iReservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/AddEvent")
    public Event addEvent(@RequestBody Event event){
        return iEventService.addEvent(event);
    }
    @GetMapping("/allEvent")
    public ResponseEntity<List<Event>> getAllEvent (){
        List<Event> events = iEventService.findAllEvent();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @PutMapping("/updateEvent")
    public ResponseEntity<Event> updateEvent(@RequestBody Event event){
        Event updateEvent = iEventService.updateEvent(event);
        return new ResponseEntity<>(updateEvent, HttpStatus.OK);
    }
    @DeleteMapping("/deleteEvent/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") Long id){
        iEventService.deleteEvent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/AddCenterOfCamp")
    public CenterOfCamp addCenterOfCamp(@RequestBody CenterOfCamp centerOfCamp){
        return iCenterOfCampService.addCenterOfCamp(centerOfCamp);
    }
    @GetMapping("/allCenterOfCamp")
    public ResponseEntity<List<CenterOfCamp>> getAllCenterOfCamp (){
        List<CenterOfCamp> centerOfCamps = iCenterOfCampService.findAllCenterOfCamp();
        return new ResponseEntity<>(centerOfCamps, HttpStatus.OK);
    }

    @PutMapping("/updateCenterOfCamp")
    public ResponseEntity<CenterOfCamp> updateEmployee(@RequestBody CenterOfCamp centerOfCamp){
        CenterOfCamp updateCenterOfCamp1 = iCenterOfCampService.updateCenterOfCamp(centerOfCamp);
        return new ResponseEntity<>(updateCenterOfCamp1, HttpStatus.OK);
    }
    @DeleteMapping("/deleteCenterOfCamp/{id}")
    public ResponseEntity<?> deleteCenterOfCamp(@PathVariable("id") Long id){
        iCenterOfCampService.deleteCenterOfCamp(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/AddCampsite")
    public Campsite addCampsite(@RequestBody Campsite campsite){
        return iCampsiteService.addCampsite(campsite);
    }
    @GetMapping("/allCampsite")
    public ResponseEntity<List<Campsite>> getAllCampsite (){
        List<Campsite> campsites = iCampsiteService.findAllCampsite();
        return new ResponseEntity<>(campsites, HttpStatus.OK);
    }

    @PutMapping("/updateCampsite")
    public ResponseEntity<Campsite> updateCampsite(@RequestBody Campsite campsite){
        Campsite updateCampsite1 = iCampsiteService.updateCampsite(campsite);
        return new ResponseEntity<>(updateCampsite1, HttpStatus.OK);
    }
    @DeleteMapping("/deleteCampsite/{id}")
    public ResponseEntity<?> deleteCampsite(@PathVariable("id") Long id){
        iCampsiteService.deleteCampsite(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/AddActivity")
    public Activity addActivity(@RequestBody Activity activity){
        return iActivityService.addActivity(activity);
    }
    @GetMapping("/allActivity")
    public ResponseEntity<List<Activity>> getAllActivity (){
        List<Activity> activities = iActivityService.findAllActivity();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @PutMapping("/updateActivity")
    public ResponseEntity<Activity> updateActivity(@RequestBody Activity activity){
        Activity updateActivity1 = iActivityService.updateActivity(activity);
        return new ResponseEntity<>(updateActivity1, HttpStatus.OK);
    }
    @DeleteMapping("/deleteActivity/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable("id") Long id){
        iActivityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }







}
