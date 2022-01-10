package com.lipaco.domain.survey;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;



import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SurveyRepositoryTest {

    @Autowired
    SurveyRepository surveyRepository;

    @AfterEach
    public void cleanup() {
        surveyRepository.deleteAll();
    }

    @Test
    public void 설문조사_불러오기() {
        //given
        String brand = "테스트기업";
        int star = 3;
        String contents = "무난했어요.";

        surveyRepository.save(Survey.builder()
                .brand(brand)
                .star(star)
                .comment(contents)
                .build());

        // when
        List<Survey> surveyList = surveyRepository.findAll();

        // then
        Survey survey = surveyList.get(0);
        System.out.println(survey.getBrand());

        assertThat(survey.getBrand()).isEqualTo(brand);

    }
}
