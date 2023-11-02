package me.mtron.hostelmanagementsystembackend.controllers;

import me.mtron.hostelmanagementsystembackend.httpentities.Complaint;
import me.mtron.hostelmanagementsystembackend.models.DailyReport;
import me.mtron.hostelmanagementsystembackend.models.StudentRoom;
import me.mtron.hostelmanagementsystembackend.projection.DailyReportProjection;
import me.mtron.hostelmanagementsystembackend.projection.StudentRoomProjection;
import me.mtron.hostelmanagementsystembackend.repo.ComplaintRepo;
import me.mtron.hostelmanagementsystembackend.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class ComplaintController {
    @Autowired
    private ComplaintRepo complaintRepo;

    @Autowired
    private ComplaintService complaintService;

    @PostMapping("/complaint")
    public ResponseEntity<Complaint> saveComplaint(@RequestBody Complaint c) {
        c = this.complaintService.handleRegistration(c);
        return ResponseEntity.ok().body(c);
    }

    @GetMapping("/complaint")
    public ResponseEntity<List<Complaint>> getAllComplaints() {
        List<Complaint> all = complaintRepo.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/complaint/{id}")
    public ResponseEntity<Optional<Complaint>> findComplaint(@PathVariable Long id) {
        Optional<Complaint> c = this.complaintRepo.findById(id);
        return ResponseEntity.ok().body(c);
    }

    @DeleteMapping("/complaint/{id}")
    public ResponseEntity<Optional<Complaint>> deleteComplaint(@PathVariable Long id) {
        if (complaintRepo.existsById(id)) {
            this.complaintRepo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(400).build();
    }

    @GetMapping("/daily_report")
    public ResponseEntity<List<DailyReport>> getDailyReport() {
        List<DailyReportProjection> projections = complaintRepo.getDailyReport();
        List<DailyReport> reports = new ArrayList<>();
        for(DailyReportProjection projection : projections) {
            DailyReport report = new DailyReport();
            report.setComplaint_id(projection.getComplaint_id());
            report.setDescription(projection.getDescription());
            report.setImage_url(projection.getImage_url());
            report.setItem_code(projection.getItem_code());
            report.setItem_name(projection.getItem_name());
            report.setRoom_no(projection.getRoom_no());
            report.setHostel_type(projection.getHostel_type());
            report.setStu_no(projection.getStu_no());
            report.setStudent_name(projection.getStudent_name());
            report.setStatus(projection.getStatus());
            report.setComplaint_created_date(projection.getComplaint_created_date());
            reports.add(report);
        }
        return ResponseEntity.ok(reports);
    }
}
