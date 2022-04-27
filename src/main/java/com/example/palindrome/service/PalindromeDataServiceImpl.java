package com.example.palindrome.service;

import com.example.palindrome.dto.PalindromeCalculationRequestDto;
import com.example.palindrome.model.PalindromeData;
import com.example.palindrome.repository.PalindromeDataRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PalindromeDataServiceImpl implements PalindromeDataService {

  @Autowired
  private PalindromeDataRepository palindromeDataRepository;

  @Autowired
  private ModelMapper mapper;

  @Override
  public void save(PalindromeCalculationRequestDto palindromeCalculationRequestDto, int longestPalindromeSize) {
    PalindromeData palindromeData = mapper.map(palindromeCalculationRequestDto, PalindromeData.class);
    palindromeData.setLongestPalindromeSize(longestPalindromeSize);
    palindromeDataRepository.save(palindromeData);
  }
}
