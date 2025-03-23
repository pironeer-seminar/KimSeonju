package com.SpringBoot.SpringBoot.service;

import com.SpringBoot.SpringBoot.dto.TextResponseDto;
import org.springframework.stereotype.Service;

@Service
public class TextAnalysisService {

    public TextResponseDto analyzeText(String sentence) {
        int length = sentence.length();
        int wordCount = sentence.split("\\s+").length;  // " \\s+ " : 공백(스페이스, 탭, 줄 바꿈 등)을 연속된 개수에 상관없이 하나의 구분자로 사용
        boolean containSpring = sentence.toLowerCase().contains("spring");

        return new TextResponseDto(length, wordCount, containSpring);
    }
}
