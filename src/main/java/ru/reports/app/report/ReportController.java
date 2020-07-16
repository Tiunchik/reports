package ru.reports.app.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportController {

    private final ReportService repService;

    public ReportController(@Autowired ReportService repService) {
        this.repService = repService;
    }


    @GetMapping("/report")
    public ResponseEntity<List<ReportDTO>> getSpeakers(){
        return new ResponseEntity<>(repService.getAllReports(), HttpStatus.OK);
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<ReportDTO> getSpeaker(@PathVariable int id) {
        ReportDTO emp = repService.getReportById(id);
        if (emp != null) {
            return new ResponseEntity<>(emp, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/report")
    public ResponseEntity<ReportDTO> saveSpeaker(@RequestBody ReportDTO reportDTO){
        if (reportDTO.getId() != 0) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        ReportDTO answer = repService.saveOrUpdateReport(reportDTO);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @PutMapping("/report")
    public ResponseEntity<ReportDTO> updateSpeaker(@RequestBody ReportDTO reportDTO){
        if (reportDTO.getId() == 0) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        ReportDTO answer = repService.saveOrUpdateReport(reportDTO);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @DeleteMapping("/report/{id}")
    public ResponseEntity<Void> deleteSpeaker(@PathVariable long id) {
        repService.deleteReposrt(id);
        return ResponseEntity.noContent().build();
    }

}
