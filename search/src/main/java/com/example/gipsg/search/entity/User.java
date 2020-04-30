package com.example.gipsg.search.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "user")
public class User implements Serializable {

    public User() {
    }

    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "office")
    private String office;

    @Column(name = "hobby")
    private String hobby;

}