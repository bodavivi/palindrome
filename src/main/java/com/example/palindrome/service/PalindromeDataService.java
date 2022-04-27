package com.example.palindrome.service;

import com.example.palindrome.dto.PalindromeCalculationRequestDto;
import com.example.palindrome.dto.PalindromeDataDto;

import java.util.List;

public interface PalindromeDataService {

  void save(PalindromeCalculationRequestDto palindromeCalculationRequestDto, int longestPalindromeSize);

  List<PalindromeDataDto> getAll();
}
