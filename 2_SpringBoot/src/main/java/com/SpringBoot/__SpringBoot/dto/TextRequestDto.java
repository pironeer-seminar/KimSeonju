package com.SpringBoot.__SpringBoot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter   // sentence 값을 읽을 때 사용
@Setter   // JSON 요청 테이터를 객체에 매핑할 때 사용 (this.sentence = sentence;)
public class TextRequestDto {
    @NotBlank(message = "문장은 필수 입력값입니다.")  // "sentence" 필드가 비어 있거나 공백이면 오류 반환
    private String sentence;
}
