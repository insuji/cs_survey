package com.lipaco.web;

import com.lipaco.domain.survey.Survey;
import com.lipaco.domain.survey.SurveyRepository;
import com.lipaco.service.SurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SurveyController {

//    private final SurveyService surveyService;

    @GetMapping("/index")
    public String index() {
        log.info("index");
        return "index";
    }

    @PostMapping("/submitForm")
    public String save() {
        log.info("submit success");
//        SurveyService.save(survey);
        return "result";
    }


//    public void init() {
//        SurveyRepository.save(new Survey("aguard", 3, "good"));
//        SurveyRepository.save(new Survey("monoflat", 3, "good"));
//    }





}
