package me.mtron.hostelmanagementsystembackend.service;

import me.mtron.hostelmanagementsystembackend.httpentities.Complaint;
import me.mtron.hostelmanagementsystembackend.repo.ComplaintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComplaintService {
    @Autowired
    private ComplaintRepo complaintRepo;

    public Complaint handleRegistration(Complaint c){
        return this.complaintRepo.save(c);
    }
}
