package com.example.palindrome.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PalindromeCalculationRequestDto {

  private String content;

  private LocalDateTime timestamp;

}
