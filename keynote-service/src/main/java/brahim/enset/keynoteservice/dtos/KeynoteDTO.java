package brahim.enset.keynoteservice.dtos;

import lombok.*;

@Data @Setter @Getter @AllArgsConstructor @NoArgsConstructor @Builder
public class KeynoteDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String function;
}