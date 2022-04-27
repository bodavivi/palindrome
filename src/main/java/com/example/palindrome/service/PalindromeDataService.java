package com.example.palindrome.service;

import com.example.palindrome.dto.PalindromeCalculationRequestDto;

public interface PalindromeDataService {

  void save(PalindromeCalculationRequestDto palindromeCalculationRequestDto, int longestPalindromeSize);

}
