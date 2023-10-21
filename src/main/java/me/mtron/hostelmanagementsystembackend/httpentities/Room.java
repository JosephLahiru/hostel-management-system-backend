package me.mtron.hostelmanagementsystembackend.httpentities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;
    private int room_no;
    private int no_of_items;
    private int no_of_students;

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
}
