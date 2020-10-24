package com.example.gipsg.search.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="profile")
public class Profile implements Serializable {
//    @NotBlank(message="Please provide a response")
//    @Column(name="answer")
    private List<String> answer;
    private List<String> checkBoxAnswer;
}