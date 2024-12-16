package brahim.enset.conferenceservice.dtos;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ReviewDTO {

    private Long id;
    private LocalDate date;
    private String text;
    private int stars;

}

