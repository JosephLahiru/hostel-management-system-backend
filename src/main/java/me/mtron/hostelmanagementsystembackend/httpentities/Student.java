package me.mtron.hostelmanagementsystembackend.httpentities;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String reg_number;
    private String first_name;
    private String last_name;
    private String phone_number;
    private String email;
    private int room_number;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @PrePersist
    public void prePersist() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR, 5);
        calendar.add(Calendar.MINUTE, 30);
        this.created_at = calendar.getTime();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getReg_number() {
        return reg_number;
    }

    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
