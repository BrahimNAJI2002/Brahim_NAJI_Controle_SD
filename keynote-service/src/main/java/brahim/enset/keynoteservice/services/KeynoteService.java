package brahim.enset.keynoteservice.services;

import brahim.enset.keynoteservice.dtos.KeynoteDTO;

import java.util.List;
import java.util.Optional;

public interface KeynoteService {
    List<KeynoteDTO> getAllKeynotes();
    Optional<KeynoteDTO> getKeynoteById(Long id);
    KeynoteDTO saveKeynote(KeynoteDTO keynoteDTO);
    void deleteKeynote(Long id);
}
