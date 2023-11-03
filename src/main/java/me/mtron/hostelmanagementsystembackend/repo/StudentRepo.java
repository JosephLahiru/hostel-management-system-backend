package me.mtron.hostelmanagementsystembackend.repo;

import me.mtron.hostelmanagementsystembackend.httpentities.Student;
import me.mtron.hostelmanagementsystembackend.projection.StudentRoomProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query(value = "SELECT s.reg_number AS regNumber, s.room_number AS roomNumber " +
            "FROM room_property rp " +
            "JOIN room r ON rp.room_id = r.id " +
            "JOIN property p ON rp.property_id = p.id " +
            "JOIN student s ON r.room_no = s.room_number" +
            "WHERE rp.property_id = :propertyId", nativeQuery = true)
    List<StudentRoomProjection> findStudentRoomByPropertyId(String propertyId);

}
