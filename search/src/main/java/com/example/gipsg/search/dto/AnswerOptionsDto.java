package com.example.gipsg.search.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AnswerOptionsDto {
    private String id;
    private String value;
    private String answer;
}
