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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @GetMapping("/index/{brand}")
    public String index(@PathVariable("brand") String brand,
                        Model model) {
        model.addAttribute("brand", brand);
        return "index";
    }

    @PostMapping("/submitForm")
    public String save(@ModelAttribute("item") SurveyRequestDto survey,
                       @RequestParam("brand") String brand,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        surveyService.save(survey);

        redirectAttributes.addAttribute("brand", brand);
        log.info("brand1={}", brand);
        return "redirect:result";
    }

    @GetMapping("/result")
    public String result(@RequestParam("brand") String brand,
                       Model model) {

        String mallUrl;
        log.info("brand={}", brand);
        if (brand.equals("aguard")) {
            mallUrl = "https://www.aguardmall.com/";
        } else if (brand.equals("monoflat")) {
            mallUrl =  "www.monoflat.com";
        } else {
            mallUrl = "https://www.petrium.co.kr/";
        }

        model.addAttribute("mallUrl", mallUrl);
        return "result";
    }

}
