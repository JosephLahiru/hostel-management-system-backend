package me.mtron.hostelmanagementsystembackend.repo;

import me.mtron.hostelmanagementsystembackend.httpentities.Complaint;
import me.mtron.hostelmanagementsystembackend.projection.DailyReportProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplaintRepo extends JpaRepository<Complaint, Long> {
    @Query(value = "SELECT * FROM daily_report_view;", nativeQuery = true)
    List<DailyReportProjection> getDailyReport();

    @Query(value = "SELECT * FROM monthly_report_view;", nativeQuery = true)
    List<DailyReportProjection> getMonthlyReport();
}
