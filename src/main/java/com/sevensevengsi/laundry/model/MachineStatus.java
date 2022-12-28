package com.sevensevengsi.laundry.model;

import javax.persistence.*;

@Entity
@Table(name = "machine_status")
public class MachineStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status", nullable = false)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public MachineStatus(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public MachineStatus(){

    }
}
