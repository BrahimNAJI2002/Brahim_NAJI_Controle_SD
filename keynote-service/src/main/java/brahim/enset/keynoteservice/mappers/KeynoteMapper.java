package brahim.enset.keynoteservice.mappers;


import brahim.enset.keynoteservice.dtos.KeynoteDTO;
import brahim.enset.keynoteservice.entities.Keynote;
import org.springframework.stereotype.Component;

@Component
public class KeynoteMapper {

    public KeynoteDTO toDTO(Keynote keynote) {
        KeynoteDTO dto = new KeynoteDTO();
        dto.setId(keynote.getId());
        dto.setFirstName(keynote.getFirstName());
        dto.setLastName(keynote.getLastName());
        dto.setEmail(keynote.getEmail());
        dto.setFunction(keynote.getFunction());
        return dto;
    }

    public Keynote toEntity(KeynoteDTO dto) {
        return Keynote.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .function(dto.getFunction())
                .build();
    }
}
