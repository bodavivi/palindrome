package com.example.palindrome.service;

import com.example.palindrome.dto.PalindromeCalculationRequestDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeServiceImplUnitTest {

  @InjectMocks
  private PalindromeServiceImpl palindromeService;

  @Mock
  private PalindromeCalculationService palindromeCalculationService;

  @Mock
  private PalindromeDataService palindromeDataService;

  @Rule
  public ExpectedException expectedException = ExpectedException.none();

  private PalindromeCalculationRequestDto requestDto;

  @Before
  public void setUp() {
    requestDto = new PalindromeCalculationRequestDto();
    requestDto.setContent("cision");
    requestDto.setTimestamp(LocalDateTime.now());
  }

  @Test
  public void processCalculation_should_throw_exception_if_content_is_missing_from_request() {
    requestDto.setContent(null);

    expectedException.expect(ResponseStatusException.class);
    expectedException.expectMessage("The 'content' and the 'timestamp' fields are required");

    palindromeService.processCalculation(requestDto);
  }

  @Test
  public void processCalculation_should_throw_exception_if_timestamp_is_missing_from_request() {
    requestDto.setTimestamp(null);

    expectedException.expect(ResponseStatusException.class);
    expectedException.expectMessage("The 'content' and the 'timestamp' fields are required");

    palindromeService.processCalculation(requestDto);
  }

  @Test
  public void processCalculation_should_throw_exception_if_content_contains_not_just_alphabetical_character() {
    requestDto.setContent("h3ll0");

    expectedException.expect(ResponseStatusException.class);
    expectedException.expectMessage("Only alphabetical characters are allowed.");

    palindromeService.processCalculation(requestDto);
  }

  @Test
  public void processCalculation_should_return_with_max_palindrome_size() {
    Mockito.when(palindromeCalculationService.calculateLongestPalindromeSize(requestDto.getContent())).thenReturn(3);

    int result = palindromeService.processCalculation(requestDto);

    Mockito.verify(palindromeCalculationService, Mockito.times(1))
        .calculateLongestPalindromeSize(requestDto.getContent());
    Mockito.verify(palindromeDataService, Mockito.times(1)).save(requestDto, 3);
    Assert.assertEquals(3, result);
  }



}
