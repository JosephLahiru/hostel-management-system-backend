package me.mtron.hostelmanagementsystembackend.service;

import me.mtron.hostelmanagementsystembackend.httpentities.Property;
import me.mtron.hostelmanagementsystembackend.repo.PropertyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PropertyService {
    @Autowired
    private PropertyRepo propertyRepo;

    public Property handleRegistration(Property p){return this.propertyRepo.save(p);}
}
