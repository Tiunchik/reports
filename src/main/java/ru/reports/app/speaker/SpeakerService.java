package ru.reports.app.speaker;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpeakerService {

    private final SpeakerRepository speakRepository;

    private final ModelMapper mapper;

    public SpeakerService(SpeakerRepository speakRepository,
                         ModelMapper mapper) {
        this.speakRepository = speakRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<SpeakerDTO> getAllSpeakers(){
        return speakRepository.findAll().stream()
                .map(e -> mapper.map(e, SpeakerDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SpeakerDTO getSpeakerById(int id) {
        Optional<Speaker> emp = speakRepository.findById(id);
        return emp
                .map(e -> mapper.map(e, SpeakerDTO.class))
                .orElse(null);
    }

    @Transactional
    public SpeakerDTO saveOrUpdateSpeaker(SpeakerDTO speakerDTO){
        return mapper
                .map(speakRepository
                                .save(mapper
                                        .map(speakerDTO, Speaker.class)),
                        SpeakerDTO.class);
    }

    @Transactional
    public void deleteSpeaker(int id) {
        speakRepository.deleteById(id);
    }


}
