package me.mtron.hostelmanagementsystembackend.service;

import me.mtron.hostelmanagementsystembackend.httpentities.Room;
import me.mtron.hostelmanagementsystembackend.repo.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomService {

    @Autowired
    private RoomRepo roomRepo;

    public Room handleRegistration(Room r){return this.roomRepo.save(r);}
}
