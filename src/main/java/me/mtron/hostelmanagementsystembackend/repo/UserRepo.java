package me.mtron.hostelmanagementsystembackend.repo;

import me.mtron.hostelmanagementsystembackend.httpentities.User;
import me.mtron.hostelmanagementsystembackend.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<ApplicationUser, Integer> {
    Optional<ApplicationUser> findByUsername(String username);
}
