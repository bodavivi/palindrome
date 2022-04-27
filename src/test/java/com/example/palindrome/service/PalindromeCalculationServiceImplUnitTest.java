package com.example.palindrome.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeCalculationServiceImplUnitTest {

  @InjectMocks
  private PalindromeCalculationServiceImpl palindromeCalculationService;

  @Test
  public void calculateLongestPalindromeSize_should_return_1_if_there_is_no_palindromes_in_the_input_content() {
    int result = palindromeCalculationService.calculateLongestPalindromeSize("palindrome");
    Assert.assertEquals(1, result);
  }

  @Test
  public void calculateLongestPalindromeSize_should_return_input_content_size_if_the_whole_content_is_a_palindrome() {
    int result = palindromeCalculationService.calculateLongestPalindromeSize("abba");
    Assert.assertEquals(4, result);
  }

  @Test
  public void calculateLongestPalindromeSize_should_return_the_right_number_of_palindromes_size() {
    int result = palindromeCalculationService.calculateLongestPalindromeSize("abrakadabra");
    Assert.assertEquals(3, result);
  }

  @Test
  public void calculateLongestPalindromeSize_should_return_the_right_number_of_palindromes_size_if_the_palindrome_is_not_symmetrical_by_lower_and_camel_case() {
    int result = palindromeCalculationService.calculateLongestPalindromeSize("cIsion");
    Assert.assertEquals(3, result);
  }
}
