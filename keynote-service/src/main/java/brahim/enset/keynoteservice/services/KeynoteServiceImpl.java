package brahim.enset.keynoteservice.services;


import brahim.enset.keynoteservice.dtos.KeynoteDTO;
import brahim.enset.keynoteservice.entities.Keynote;
import brahim.enset.keynoteservice.mappers.KeynoteMapper;
import brahim.enset.keynoteservice.repositories.KeynoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KeynoteServiceImpl implements KeynoteService {

    private final KeynoteRepository keynoteRepository;
    private final KeynoteMapper keynoteMapper;

    public KeynoteServiceImpl(KeynoteRepository keynoteRepository, KeynoteMapper keynoteMapper) {
        this.keynoteRepository = keynoteRepository;
        this.keynoteMapper = keynoteMapper;
    }

    @Override
    public List<KeynoteDTO> getAllKeynotes() {
        return keynoteRepository.findAll().stream()
                .map(keynoteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<KeynoteDTO> getKeynoteById(Long id) {
        return keynoteRepository.findById(id)
                .map(keynoteMapper::toDTO);
    }

    @Override
    public KeynoteDTO saveKeynote(KeynoteDTO keynoteDTO) {
        Keynote keynote = keynoteMapper.toEntity(keynoteDTO);
        Keynote savedKeynote = keynoteRepository.save(keynote);
        return keynoteMapper.toDTO(savedKeynote);
    }

    @Override
    public void deleteKeynote(Long id) {
        keynoteRepository.deleteById(id);
    }
}
