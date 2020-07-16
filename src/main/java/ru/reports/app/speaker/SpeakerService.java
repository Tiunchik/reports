package ru.reports.app.speaker;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpeakerService {

    private final SpeakerRepository speakRepository;

    private final ModelMapper mapper;

    public SpeakerService(@Autowired SpeakerRepository speakRepository,
                         @Autowired ModelMapper mapper) {
        this.speakRepository = speakRepository;
        this.mapper = mapper;
    }

    public List<SpeakerDTO> getAllSpeakers(){
        return speakRepository.findAll().stream()
                .map(e -> mapper.map(e, SpeakerDTO.class))
                .collect(Collectors.toList());
    }

    public SpeakerDTO getSpeakerById(int id) {
        Optional<Speaker> emp = speakRepository.findById(id);
        return emp
                .map(e -> mapper.map(e, SpeakerDTO.class))
                .orElse(null);
    }

    public SpeakerDTO saveOrUpdateSpeaker(SpeakerDTO speakerDTO){
        return mapper
                .map(speakRepository
                                .save(mapper
                                        .map(speakerDTO, Speaker.class)),
                        SpeakerDTO.class);
    }

    public void deleteSpeaker(int id) {
        speakRepository.deleteById(id);
    }


}
