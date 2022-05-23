package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    // DTO (data transfer object)
    // 여기에 read-only 속성 가지면 vo 라고 함.

    @NotBlank(message = "{required.user.userName}")
    private String name;

    @Max(value = 100,message = "{max.age.number}")
    @Min(value = 20,message = "{min.age.number}")
    private int age;
}
