package me.mtron.hostelmanagementsystembackend.httpentities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private int room_no;
    private int no_of_items;
    private int no_of_students;
    private String hostel_type;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getRoom_no() {
        return room_no;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    public int getNo_of_items() {
        return no_of_items;
    }

    public void setNo_of_items(int no_of_items) {
        this.no_of_items = no_of_items;
    }

    public int getNo_of_students() {
        return no_of_students;
    }

    public void setNo_of_students(int no_of_students) {
        this.no_of_students = no_of_students;
    }

    public String getHostel_type() {
        return hostel_type;
    }

    public void setHostel_type(String hostel_type) {
        this.hostel_type = hostel_type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
