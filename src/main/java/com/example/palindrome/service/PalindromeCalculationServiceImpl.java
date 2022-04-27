package com.example.palindrome.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PalindromeCalculationServiceImpl implements PalindromeCalculationService {

  Logger logger = LoggerFactory.getLogger(PalindromeCalculationServiceImpl.class);

  @Override
  public int calculateLongestPalindromeSize(String content) {
    logger.info("calculation started at {}", LocalDateTime.now());
    int maximumPalindromeLength = 1;
    for (int i = 0; i < content.length() - 1; i++) {
      for (int j = i + 2; j <= content.length(); j++) {
        String contentFragment = content.substring(i, j);
        String reverseContentFragment = new StringBuilder(contentFragment).reverse().toString();
        if (contentFragment.equals(reverseContentFragment) && contentFragment.length() > maximumPalindromeLength)
          maximumPalindromeLength = contentFragment.length();
      }
    }
    logger.info("calculation ended at {}", LocalDateTime.now());
    return maximumPalindromeLength;
  }
}
