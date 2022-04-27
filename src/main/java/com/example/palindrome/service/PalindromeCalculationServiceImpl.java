package com.example.palindrome.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeCalculationServiceImpl implements PalindromeCalculationService {

  @Override
  public int calculateLongestPalindromeSize(String content) {
    int maximumPalindromeLength = 1;
    for (int i = 0; i < content.length() - 1; i++) {
      for (int j = i + 2; j <= content.length(); j++) {
        String contentFragment = content.substring(i, j);
        String reverseContentFragment = new StringBuilder(contentFragment).reverse().toString();
        if (contentFragment.equals(reverseContentFragment) && contentFragment.length() > maximumPalindromeLength)
          maximumPalindromeLength = contentFragment.length();
      }
    }
    return maximumPalindromeLength;
  }
}
