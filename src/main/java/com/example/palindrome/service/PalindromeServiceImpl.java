package com.example.palindrome.service;

import com.example.palindrome.dto.PalindromeCalculationRequestDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.regex.Pattern;

@Service
public class PalindromeServiceImpl implements PalindromeService {

  @Autowired
  private PalindromeCalculationService palindromeCalculationService;

  @Autowired
  private PalindromeDataService palindromeDataService;

  @Override
  public int processCalculation(PalindromeCalculationRequestDto palindromeCalculationRequestDto) {
    validatePalindromeCalculationRequest(palindromeCalculationRequestDto);
    int maxPalindromeSize =
        palindromeCalculationService.calculateLongestPalindromeSize(palindromeCalculationRequestDto.getContent());
    palindromeDataService.save(palindromeCalculationRequestDto, maxPalindromeSize);
    return maxPalindromeSize;
  }

  private void validatePalindromeCalculationRequest(PalindromeCalculationRequestDto palindromeCalculationRequestDto) {
    if (StringUtils.isBlank(palindromeCalculationRequestDto.getContent())
        || palindromeCalculationRequestDto.getTimestamp() == null) {
      throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
          "The 'content' and the 'timestamp' fields are required");
    }

    Pattern allowedCharacters = Pattern.compile("[A-záéíóöőúüűÁÉÍÓÖŐÚÜŰ]*");
    if (!allowedCharacters.matcher(palindromeCalculationRequestDto.getContent()).matches()) {
      throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Only alphabetical characters are allowed.");
    }

  }
}
