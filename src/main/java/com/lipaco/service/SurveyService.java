package com.lipaco.service;

import com.lipaco.domain.survey.Survey;
import com.lipaco.domain.survey.SurveyRepository;
import com.lipaco.web.SurveyRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Transactional
    public Long save(SurveyRequestDto surveyDto) {
        return surveyRepository.save(surveyDto.toEntity()).getId();
    }

}
