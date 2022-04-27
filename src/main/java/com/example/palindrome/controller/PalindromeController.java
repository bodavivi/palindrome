package com.example.palindrome.controller;

import com.example.palindrome.dto.PalindromeCalculationRequestDto;
import com.example.palindrome.dto.PalindromeDataDto;
import com.example.palindrome.service.PalindromeDataService;
import com.example.palindrome.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/palindrome")
public class PalindromeController {

  @Autowired
  private PalindromeService palindromeService;

  @Autowired
  private PalindromeDataService palindromeDataService;

  @PostMapping("/calculate")
  public Integer processPalindromeCalculation(
      @RequestBody PalindromeCalculationRequestDto palindromeCalculationRequestDto) {
    return palindromeService.processCalculation(palindromeCalculationRequestDto);
  }

  @GetMapping
  public List<PalindromeDataDto> getAllPalindromeData() {
    return palindromeDataService.getAll();
  }
}
