package me.mtron.hostelmanagementsystembackend.service;

import me.mtron.hostelmanagementsystembackend.httpentities.Hostel;
import me.mtron.hostelmanagementsystembackend.repo.HostelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HostelService {
    @Autowired
    private HostelRepo hostelRepo;

    public Hostel handleRegistration(Hostel h){
        return this.hostelRepo.save(h);
    }
}
