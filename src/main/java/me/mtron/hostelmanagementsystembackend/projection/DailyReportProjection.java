package me.mtron.hostelmanagementsystembackend.projection;

import java.util.Date;

public interface DailyReportProjection {
    int getComplaint_id();
    String getDescription();
    String getImage_url();
    String getItem_code();
    String getItem_name();
    int getRoom_no();
    String getHostel_type();
    String getStu_no();
    String getStudent_name();
    String getStatus();
    Date getComplaint_created_date();
}
