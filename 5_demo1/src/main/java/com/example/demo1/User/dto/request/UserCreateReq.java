package com.example.demo1.User.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class UserCreateReq {

    @Schema(description = "유저 이름", example = "홍길동")
    @NotBlank(message = "유저 이름은 필수입니댜.") //Validation
    private String name;
}
