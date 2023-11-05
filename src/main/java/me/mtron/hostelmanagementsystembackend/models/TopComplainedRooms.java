package me.mtron.hostelmanagementsystembackend.models;

public class TopComplainedRooms {
    String room_no;
    int complaint_count;

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public int getComplaint_count() {
        return complaint_count;
    }

    public void setComplaint_count(int complaint_count) {
        this.complaint_count = complaint_count;
    }
}
