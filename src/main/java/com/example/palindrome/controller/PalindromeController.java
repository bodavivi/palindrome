package com.example.palindrome.controller;

import com.example.palindrome.dto.PalindromeCalculationRequestDto;
import com.example.palindrome.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/palindrome")
public class PalindromeController {

  @Autowired
  private PalindromeService palindromeService;

  @PostMapping("/calculate")
  public Integer processPalindromeCalculation(
      @RequestBody PalindromeCalculationRequestDto palindromeCalculationRequestDto) {
    return palindromeService.processCalculation(palindromeCalculationRequestDto);
  }
}
