package com.SpringBoot.SpringBoot.dto;

import lombok.Getter;

@Getter
public class TextResponseDto {
    private final int length;
    private final int wordCount;
    private final boolean containSpring;

    // 생성자
    public TextResponseDto(int length, int wordCount, boolean containSpring) {
        this.length = length;
        this.wordCount = wordCount;
        this.containSpring = containSpring;
    }

}
