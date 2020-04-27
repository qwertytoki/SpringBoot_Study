package com.example.gipsg.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="user")
public class Search implements Serializable {

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