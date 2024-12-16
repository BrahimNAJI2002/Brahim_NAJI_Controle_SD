package brahim.enset.conferenceservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String text;
    private int stars; // Note entre 1 et 5

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;
}
