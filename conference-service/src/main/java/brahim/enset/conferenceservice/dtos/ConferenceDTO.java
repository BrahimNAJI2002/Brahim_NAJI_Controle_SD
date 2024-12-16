package brahim.enset.conferenceservice.dtos;

import lombok.*;

import java.time.Duration;
import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor @Builder @Setter @Getter
public class ConferenceDTO {

    private Long id;
    private String title;
    private String type;
    private LocalDate date;
    private Duration duration;
    private int numberOfAttendees;
    private double score;

}