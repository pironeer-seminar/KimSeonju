package com.SpringBoot.SpringBoot.controller;

import com.SpringBoot.SpringBoot.dto.TextRequestDto;
import com.SpringBoot.SpringBoot.dto.TextResponseDto;
import com.SpringBoot.SpringBoot.service.TextAnalysisService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TextAnalysisController {

    // 의존성 주입
    // Spring이 TextAnalysisService 객체를 자동으로 생성해주고 연결해 줌(Spring의 @Service 덕분에 자동으로 주입됨!)
    // private final TextAnalysisService textAnalysisService = new TextAnalysisService(); // 직접 생성
    private final TextAnalysisService textAnalysisService;  // 1. 필드 선언

    // 2. 생성자를 통한 의존성 주입
    public TextAnalysisController(TextAnalysisService textAnalysisService) {
        this.textAnalysisService = textAnalysisService;
    }

    @PostMapping("/analyze")
    public TextResponseDto analyzeText(@Valid @RequestBody TextRequestDto textRequestDto) {  // @RequestBody : JSON -> TextRequestDto , @Valid - @NotBlank
        return textAnalysisService.analyzeText(textRequestDto.getSentence());
    }
}
