package me.mtron.hostelmanagementsystembackend.repo;

import me.mtron.hostelmanagementsystembackend.httpentities.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {
}
