package ru.reports.app.speaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SpeakerController {

    private final SpeakerService speakerService;

    public SpeakerController(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }


    @GetMapping("/speaker")
    public ResponseEntity<List<SpeakerDTO>> getSpeakers(){
        return new ResponseEntity<>(speakerService.getAllSpeakers(), HttpStatus.OK);
    }

    @GetMapping("/speaker/{id}")
    public ResponseEntity<SpeakerDTO> getSpeaker(@PathVariable int id) {
        SpeakerDTO emp = speakerService.getSpeakerById(id);
        if (emp != null) {
            return new ResponseEntity<>(emp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/speaker")
    public ResponseEntity<SpeakerDTO> saveSpeaker(@RequestBody SpeakerDTO speakerDTO){
        if (speakerDTO.getId() != 0) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        SpeakerDTO answer = speakerService.saveOrUpdateSpeaker(speakerDTO);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @PutMapping("/speaker")
    public ResponseEntity<SpeakerDTO> updateSpeaker(@RequestBody SpeakerDTO speakerDTO){
        if (speakerDTO.getId() == 0) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        SpeakerDTO answer = speakerService.saveOrUpdateSpeaker(speakerDTO);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @DeleteMapping("/speaker/{id}")
    public ResponseEntity<Void> deleteSpeaker(@PathVariable int id) {
        speakerService.deleteSpeaker(id);
        return ResponseEntity.noContent().build();
    }

}
