package com.example.palindrome.service;

import com.example.palindrome.dto.PalindromeCalculationRequestDto;
import com.example.palindrome.dto.PalindromeDataDto;
import com.example.palindrome.model.PalindromeData;
import com.example.palindrome.repository.PalindromeDataRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PalindromeDataServiceImpl implements PalindromeDataService {

  @Autowired
  private PalindromeDataRepository palindromeDataRepository;

  @Autowired
  private ModelMapper mapper;

  Logger logger = LoggerFactory.getLogger(PalindromeCalculationServiceImpl.class);

  @Override
  public void save(PalindromeCalculationRequestDto palindromeCalculationRequestDto, int longestPalindromeSize) {
    PalindromeData palindromeData = mapper.map(palindromeCalculationRequestDto, PalindromeData.class);
    palindromeData.setLongestPalindromeSize(longestPalindromeSize);
    palindromeDataRepository.save(palindromeData);
    logger.info("palindrome data is saved");
  }

  @Override
  public List<PalindromeDataDto> getAll() {
    return palindromeDataRepository.findAll().stream().map(data -> mapper.map(data, PalindromeDataDto.class))
        .collect(Collectors.toList());
  }
}
