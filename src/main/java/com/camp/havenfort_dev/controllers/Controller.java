package com.camp.havenfort_dev.controllers;


public class Controller {

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
    @GetMapping("/findReservation/{id}")
    public ResponseEntity<Reservation> getReservationById (@PathVariable("id")Long id){
        Reservation reservation = iReservationService.findReservationById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PutMapping("/updateReservation")
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation){
        Reservation updateReservation = iReservationService.updateReservation(reservation);
        return new ResponseEntity<>(updateReservation, HttpStatus.OK);
    }
    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable("id") Long id){
        iReservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/getReservation/{idEvent}")
    @ResponseBody
    public List<Reservation> getReservationByEvent(Long idEvent){
        return iReservationService.getReservationByEvent(idEvent);
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
    @GetMapping("/findEvent/{id}")
    public ResponseEntity<Event> getEventById (@PathVariable("id")Long id){
        Event event = iEventService.findById(id);
        return new ResponseEntity<>(event, HttpStatus.OK);
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
    @GetMapping("/getEventByCampsite/{idCampsite}")
    @ResponseBody
    public List<Event> getEventByCampsite(@PathVariable("idCampsite") Long idCampsite){
        return iEventService.getEventByCampsite(idCampsite);
    }
    @GetMapping("/getEventByCenterOfCamp/{idCenterOfCamp}")
    @ResponseBody
    public List<Event> getEventByCenterOfCamp(@PathVariable("idCenterOfCamp") Long idCenterOfCamp){
        return iEventService.getEventByCenterOfCamp(idCenterOfCamp);
    }
    @PostMapping ("/addEvent/{idActivity}")
    @ResponseBody
    public void addEventToActivity(@RequestBody Event event,@PathVariable("idActivity") Long idActivity){
        iEventService.addEventToActivity(event,idActivity);
    }
    @PostMapping ("/addEvent/{idReservation}")
    @ResponseBody
    public void addEventToReservation(@RequestBody Event event,@PathVariable("idReservation") Long idReservation) {
        iEventService.addEventToReservation(event,idReservation);
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
    @GetMapping("/findCenterOfCamp/{id}")
    public ResponseEntity<CenterOfCamp> getCenterOfCampById (@PathVariable("id")Long id){
        CenterOfCamp centerOfCamp = iCenterOfCampService.findById(id);
        return new ResponseEntity<>(centerOfCamp, HttpStatus.OK);
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
    @PostMapping ("/addCenterOfCamp/{idEvent}")
    public void addCenterOfCampToEvent(@RequestBody CenterOfCamp centerOfCamp,@PathVariable("idEvent") Long idEvent){
        iCenterOfCampService.addCenterOfCampToEvent(centerOfCamp,idEvent);
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
    @GetMapping("/findCampsite/{id}")
    public ResponseEntity<Campsite> getCampsiteById (@PathVariable("id")Long id){
        Campsite campsite = iCampsiteService.findById(id);
        return new ResponseEntity<>(campsite, HttpStatus.OK);
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
    @PostMapping("/addCampsite/{idEvent}")
    public void addCampsiteToEvent(@RequestBody Campsite campsite,@PathVariable("idEvent") Long idEvent){
        iCampsiteService.addCampsiteToEvent(campsite,idEvent);
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
    @GetMapping("/findActivity/{id}")
    public ResponseEntity<Activity> getActivityById (@PathVariable("id")Long id){
        Activity activity = iActivityService.findById(id);
        return new ResponseEntity<>(activity, HttpStatus.OK);
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


    @GetMapping("/getActivity/{idEvent}")
    @ResponseBody
    public List<Activity> getActivityByEvent(Long idEvent){
        return iActivityService.getActivityByEvent(idEvent);
    }
    @PutMapping("/assignActivityToEvent/{nom}/{prenom}")
    public Activity assignActivityToEvent(@RequestBody Activity activity,
                                          @PathVariable("nom") String nomE,
                                          @PathVariable("prenom") String typeE){
        return iActivityService.assignActivityToEvent(activity,nomE,typeE);
    }
    @PutMapping("/assignEventToCenterOfCamp/{nom}/{lieu}")
    public Event assignEventToCenterOfCamp(@RequestBody Event event,
                                           @PathVariable("nom") String nomC,
                                           @PathVariable("lieu") String lieuC){
        return iEventService.assignEventToCenterOfCamp(event,nomC,lieuC);
    }

}
