package me.mtron.hostelmanagementsystembackend.projection;

public interface TopComplainedRoomsProjection {
    String getRoom_no();

    void setRoom_no(String room_no);

    int getComplaint_count();

    void setComplaint_count(int complaint_count);
}
