package brahim.enset.keynoteservice.web;


import brahim.enset.keynoteservice.dtos.KeynoteDTO;
import brahim.enset.keynoteservice.services.KeynoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keynotes")
public class KeynoteRestController {

    private final KeynoteService keynoteService;

    public KeynoteRestController(KeynoteService keynoteService) {
        this.keynoteService = keynoteService;
    }

    @GetMapping
    public List<KeynoteDTO> getAllKeynotes() {
        return keynoteService.getAllKeynotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<KeynoteDTO> getKeynoteById(@PathVariable Long id) {
        return keynoteService.getKeynoteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public KeynoteDTO saveKeynote(@RequestBody KeynoteDTO keynoteDTO) {
        return keynoteService.saveKeynote(keynoteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteKeynote(@PathVariable Long id) {
        keynoteService.deleteKeynote(id);
    }
}

