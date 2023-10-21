package me.mtron.hostelmanagementsystembackend.repo;

import me.mtron.hostelmanagementsystembackend.httpentities.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostelRepo extends JpaRepository<Hostel, Long> {
}
