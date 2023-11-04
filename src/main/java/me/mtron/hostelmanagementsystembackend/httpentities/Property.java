package me.mtron.hostelmanagementsystembackend.httpentities;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
public class Property {
    @Id
    @GeneratedValue
    private Long id;
    private String prop_id;
    private String prop_name;
    private String status;
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

    public String getProp_id() {
        return prop_id;
    }

    public void setProp_id(String prop_id) {
        this.prop_id = prop_id;
    }

    public String getProp_name() {
        return prop_name;
    }

    public void setProp_name(String prop_name) {
        this.prop_name = prop_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
