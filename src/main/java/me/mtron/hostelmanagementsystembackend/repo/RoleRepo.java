package me.mtron.hostelmanagementsystembackend.repo;

import me.mtron.hostelmanagementsystembackend.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Optional<Role> findByAuthority(String authority);
}
