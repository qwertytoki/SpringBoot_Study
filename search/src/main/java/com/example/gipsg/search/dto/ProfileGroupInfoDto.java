package com.example.gipsg.search.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name = "user")
public class ProfileGroupInfoDto implements Serializable {


    @Column(name = "id")
    private Long id;
//    private Long attributeId;
//    private Boolean mainQuestionFlg;
//    private Long mainQuestionId;
//    private String question;
//    private List<String> values;
//    private Integer fieldType;
//    private Boolean mandatory;
//    private Boolean isNumber;
//    private List<AnswerOptionsDto> options;
//    private String storedColumn;
//    private String storedJson;
//    private Integer max;
//    private Integer min;
//    private String pattern;
}
