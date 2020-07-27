package ru.reports.app.report;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportService {

    private final ReportRepository repRepository;

    private final ModelMapper mapper;

    public ReportService(ReportRepository repRepository,
                          ModelMapper mapper) {
        this.repRepository = repRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<ReportDTO> getAllReports(){
        return repRepository.findAll().stream()
                .map(e -> mapper.map(e, ReportDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ReportDTO getReportById(long id) {
        Optional<Report> emp = repRepository.findById(id);
        return emp
                .map(e -> mapper.map(e, ReportDTO.class))
                .orElse(null);
    }

    @Transactional
    public ReportDTO saveOrUpdateReport(ReportDTO reportDTO){
        return mapper
                .map(repRepository
                        .save(mapper
                                .map(reportDTO, Report.class)),
                        ReportDTO.class);
    }

    @Transactional
    public void deleteReposrt(Long id) {
        repRepository.deleteById(id);
    }

}
