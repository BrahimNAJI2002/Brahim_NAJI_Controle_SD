package brahim.enset.conferenceservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity @AllArgsConstructor @NoArgsConstructor @Setter @Getter @Builder
public class Conference {

    @Id
    private Long id;
    private String title;
    private String type; // Cette propriété doit exister pour que la méthode findByType fonctionne
    private String date;
    private int duration;
    private int participantsCount;
    private double score;

    // Getters and setters...
}
