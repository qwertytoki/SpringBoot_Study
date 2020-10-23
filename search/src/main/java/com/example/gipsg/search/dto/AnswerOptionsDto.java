package com.rakuten.insight.profile.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AnswerOptionsDto {
    private String id;
    private String value;
    private String answer;
}
