package com.lipaco.web;

import com.lipaco.domain.survey.Survey;
import com.lipaco.domain.survey.SurveyRepository;
import com.lipaco.service.SurveyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping("/{brand}")
    public String index(@PathVariable("brand") String brand,
                        Model model) {
        model.addAttribute("brand", brand);
        return "index";
    }

    @PostMapping("/submitForm")
    public String save(@ModelAttribute("item") SurveyRequestDto survey,
                       @RequestParam("brand") String selectedBrand,
                       Model model) {
        surveyService.save(survey);
        String mallUrl;

        log.info("brandd={}", selectedBrand);

        if (selectedBrand.equals("aguard")) {
            mallUrl = "https://www.aguardmall.com/";
        } else if (selectedBrand.equals("monoflat")) {
            mallUrl =  "www.monoflat.com";
        } else {
            mallUrl = "https://www.petrium.co.kr/";
        }

        model.addAttribute("mallUrl", mallUrl);
        return "result";
    }

}
