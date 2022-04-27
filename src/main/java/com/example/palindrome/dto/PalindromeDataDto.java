package com.example.palindrome.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PalindromeDataDto {

  private Long id;

  private String content;

  private LocalDateTime timestamp;

  private Integer longestPalindromeSize;
}
