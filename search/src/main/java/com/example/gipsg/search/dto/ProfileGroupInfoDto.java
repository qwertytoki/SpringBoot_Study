package com.example.gipsg.search.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class ProfileGroupInfoDto {
    private Long id;
    private Long attributeId;
    private Boolean mainQuestionFlg;
    private Long mainQuestionId;
    private String question;
    private List<String> values;
    private Integer fieldType;
    private Boolean mandatory;
    private Boolean isNumber;
    private List<AnswerOptionsDto> options;
    private String storedColumn;
    private String storedJson;
    private Integer max;
    private Integer min;
    private String pattern;
}
