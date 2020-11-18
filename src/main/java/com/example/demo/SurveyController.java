package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SurveyController {

  @Autowired
  SurveyRepository surveyRepository;
  
  @GetMapping("/test")
  public void getTest() {
    System.out.println("Test");
  }

  @GetMapping("/surveys")
  public ResponseEntity<List<Survey>> getAllSurveys() {
    try {
      List<Survey> surveys = new ArrayList<Survey>();
      surveyRepository.findAll().forEach(surveys::add);
      if (surveys.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(surveys, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/surveys/{id}")
  public ResponseEntity<Survey> getSurveyById(@PathVariable("id") String id) {
    Optional<Survey> surveyData = surveyRepository.findById(id);

    if (surveyData.isPresent()) {
      return new ResponseEntity<>(surveyData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/surveys")
  public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey) {
    try {
    	Survey _survey = surveyRepository.save(new Survey(survey.getSid(),
    			survey.getFName(), survey.getLName(), survey.getAddress(),
    			survey.getCity(), survey.getState(), survey.getZip(),
    			survey.getPhone(), survey.getEmail(), survey.getDate(),
    			survey.getLikes(), survey.getInterested(), survey.getRating()));
      return new ResponseEntity<>(_survey, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/surveys/{id}")
  public ResponseEntity<Survey> updateSurvey(@PathVariable("id") String id, @RequestBody Survey survey) {
    Optional<Survey> surveyData = surveyRepository.findById(id);

    if (surveyData.isPresent()) {
    	Survey _survey = surveyData.get();
      _survey.setFName(survey.getFName());
      _survey.setLName(survey.getLName());
      _survey.setAddress(survey.getAddress());
      _survey.setCity(survey.getCity());
      _survey.setState(survey.getState());
      _survey.setZip(survey.getZip());
      _survey.setPhone(survey.getPhone());
      _survey.setEmail(survey.getEmail());
      _survey.setDate(survey.getDate());
      _survey.setLikes(survey.getLikes());
      _survey.setInterested(survey.getInterested());
      _survey.setRating(survey.getRating());
      return new ResponseEntity<>(surveyRepository.save(_survey), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/surveys/{id}")
  public ResponseEntity<HttpStatus> deleteSurvey(@PathVariable("id") String id) {
    try {
    	surveyRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/surveys")
  public ResponseEntity<HttpStatus> deleteAllSurveys() {
    try {
    	surveyRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }
}