package com.example.gipsg.search.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@Table(name="user")
public class Profile implements Serializable {

    @Column(name="answer")
    private String answer;

}