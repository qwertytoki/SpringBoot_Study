package com.example.gipsg.search.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@AllArgsConstructor
@Table(name="user")
public class User implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="nationality")
    private String nationality;

    @Column(name="office")
    private String office;

    @Column(name="hobby")
    private String hobby;

}