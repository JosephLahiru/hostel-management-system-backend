package me.mtron.hostelmanagementsystembackend.httpentities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Hostel {
    @Id
    @GeneratedValue
    private Long id;
    private int no_of_rooms;
    private int no_of_bathrooms;
    private String hostel_type;
    private String warden_name;
    private int no_of_sub_wardens;
    private int no_of_students;
    private String address;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(int no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public int getNo_of_bathrooms() {
        return no_of_bathrooms;
    }

    public void setNo_of_bathrooms(int no_of_bathrooms) {
        this.no_of_bathrooms = no_of_bathrooms;
    }

    public String getHostel_type() {
        return hostel_type;
    }

    public void setHostel_type(String hostel_type) {
        this.hostel_type = hostel_type;
    }

    public String getWarden_name() {
        return warden_name;
    }

    public void setWarden_name(String warden_name) {
        this.warden_name = warden_name;
    }

    public int getNo_of_sub_wardens() {
        return no_of_sub_wardens;
    }

    public void setNo_of_sub_wardens(int no_of_sub_wardens) {
        this.no_of_sub_wardens = no_of_sub_wardens;
    }

    public int getNo_of_students() {
        return no_of_students;
    }

    public void setNo_of_students(int no_of_students) {
        this.no_of_students = no_of_students;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
