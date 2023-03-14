package com.camp.havenfort_dev.controllers;


import com.camp.havenfort_dev.entities.*;
import com.camp.havenfort_dev.services.*;
import com.google.zxing.WriterException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/Camp")
@RestController
@AllArgsConstructor
public class Controller {



    IReservationService iReservationService;
    IEventService iEventService;
    ICenterOfCampService iCenterOfCampService;
    ICampsiteService iCampsiteService;
    IActivityService iActivityService;
    IActivityLikeService iActivityLikeService;
    IRatingService iRatingService;


    @PostMapping("/AddReservation")
    public Reservation addReservation(@RequestBody Reservation r){
        return iReservationService.addReservation(r);
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
   // @GetMapping("/getEventByCampsite/{idCampsite}")
  //  @ResponseBody
  //  public List<Event> getEventByCampsite(@PathVariable("idCampsite") Long idCampsite){
  //      return iEventService.getEventByCampsite(idCampsite);
  //  }
      @GetMapping("/getEventByCenterOfCamp/{idCenterOfCamp}")
      @ResponseBody
      public List<Event> getEventByCenterOfCamp(@PathVariable("idCenterOfCamp") Long idCenterOfCamp){
         return iEventService.getEventByCenterOfCamp(idCenterOfCamp);
    }


    @PostMapping("/AddCenterOfCamp")
    public CenterOfCamp addCenterOfCamp(@RequestBody CenterOfCamp centerOfCamp){
        return iCenterOfCampService.addCenterOfCamp(centerOfCamp);
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
    @PutMapping("/assignActivityToEvent/{nom}/{type}")
    public Activity assignActivityToEvent(@RequestBody Activity activity,
                                          @PathVariable("nom") String nomE,
                                          @PathVariable("type") String typeE){
        return iActivityService.assignActivityToEvent(activity,nomE,typeE);
    }
    @PutMapping("/assignEventToCenterOfCamp/{nom}/{lieu}")
    public Event assignEventToCenterOfCamp(@RequestBody Event event,
                                           @PathVariable("nom") String nomC,
                                           @PathVariable("lieu") String lieuC){
        return iEventService.assignEventToCenterOfCamp(event,nomC,lieuC);
    }

    @GetMapping("suggest/{id}")
    public List<Activity> suggestAct(@PathVariable("id") Long idCenter) {
        return iActivityService.suggestAct(idCenter);
    }
    @PutMapping("/addAndAssignActivityLikeToActivityAndUser/{idActivity}/{idUser}")
    public ActivityLike addAndAssignActivityLikeToActivityAndUser(@RequestBody ActivityLike activityLike,@PathVariable("idActivity") Long idActivity,@PathVariable("idUser") Long idUser){
        return iActivityLikeService.addAndAssignActivityLikeToActivityAndUser(activityLike,idActivity,idUser);
    }
    @PutMapping("/addAndAssignRatingToCenterOfCampAndUser/{idCenter}/{idUse}")
    public Rating addAndassignRatingToCenterOfCampAndUser(@RequestBody Rating r,@PathVariable("idCenter") Long idCenter,@PathVariable("idUse") Long idUse){
        return iRatingService.addAndassignRatingToCenterOfCampAndUser(r,idCenter,idUse);
    }

    @GetMapping("CalculRating/{id}")
    public float CalculRating(@PathVariable("id") Long idCenter) {
        return iRatingService.RatingCalcul(idCenter);
    }


    @PutMapping("addActivityToWishlist/{idact}/{iduser}")
    public Activity AddWishListandAddActivityToIt(@PathVariable("idact") Long idAct, @PathVariable("iduser") Long idUser) {
        return iActivityService.AddWishListandAddActivityToIt(idAct, idUser);
    }

     @GetMapping(value = "/{idCampsite}/qr-code", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody ResponseEntity<byte[]> generateQRCode(@PathVariable Long idCampsite) {
        try {
            byte[] qrCode = iCampsiteService.generateQRCode(idCampsite);
            return ResponseEntity.ok(qrCode);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
