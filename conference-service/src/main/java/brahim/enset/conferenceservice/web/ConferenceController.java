package brahim.enset.conferenceservice.web;

import brahim.enset.conferenceservice.entities.Conference;
import brahim.enset.conferenceservice.entities.Review;
import brahim.enset.conferenceservice.services.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    @PostMapping
    public ResponseEntity<Conference> createConference(@RequestBody Conference conference) {
        Conference createdConference = conferenceService.createConference(conference);
        return new ResponseEntity<>(createdConference, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Conference>> getAllConferences() {
        List<Conference> conferences = conferenceService.getAllConferences();
        return new ResponseEntity<>(conferences, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable Long id) {
        Conference conference = conferenceService.getConferenceById(id);
        return new ResponseEntity<>(conference, HttpStatus.OK);
    }

    @GetMapping("/{conferenceId}/reviews")
    public ResponseEntity<List<Review>> getReviewsByConferenceId(@PathVariable Long conferenceId) {
        List<Review> reviews = conferenceService.getReviewsByConferenceId(conferenceId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping("/{conferenceId}/reviews")
    public ResponseEntity<Review> addReviewToConference(@PathVariable Long conferenceId, @RequestBody Review review) {
        Review createdReview = conferenceService.addReviewToConference(conferenceId, review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }
}
