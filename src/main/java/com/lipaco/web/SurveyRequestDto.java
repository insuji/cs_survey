package com.lipaco.web;

import com.lipaco.domain.survey.Survey;
import lombok.Builder;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SurveyRequestDto {

    private String brand;
    private int star;
    private String attitude;
    private String know;
    private String etc;
    private String comment;

    @Builder
    public SurveyRequestDto(String brand, int star, String attitude,
                            String know, String etc, String comment) {
        this.brand = brand;
        this.star = star;
        this.attitude = attitude;
        this.know = know;
        this.etc = etc;
        this.comment = comment;
    }

    public Survey toEntity() {
        return Survey.builder()
                .brand(brand)
                .star(star)
                .attitude(attitude)
                .know(know)
                .etc(etc)
                .comment(comment)
                .build();
    }


}
