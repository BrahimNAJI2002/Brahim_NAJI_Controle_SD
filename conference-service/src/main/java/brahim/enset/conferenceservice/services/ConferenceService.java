package brahim.enset.conferenceservice.services;

import brahim.enset.conferenceservice.entities.Conference;
import brahim.enset.conferenceservice.entities.Review;
import brahim.enset.conferenceservice.repositories.ConferenceRepository;
import brahim.enset.conferenceservice.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceService {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public Conference createConference(Conference conference) {
        return conferenceRepository.save(conference);
    }

    public List<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }

    public List<Review> getReviewsByConferenceId(Long conferenceId) {
        return reviewRepository.findByConferenceId(conferenceId);
    }

    public Conference getConferenceById(Long id) {
        return conferenceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Conference not found with id " + id));
    }

    public Review addReviewToConference(Long conferenceId, Review review) {
        Conference conference = getConferenceById(conferenceId);
        review.setConference(conference);
        return reviewRepository.save(review);
    }
}
