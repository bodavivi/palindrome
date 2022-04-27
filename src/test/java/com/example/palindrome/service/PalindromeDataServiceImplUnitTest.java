package com.example.palindrome.service;

import com.example.palindrome.dto.PalindromeCalculationRequestDto;
import com.example.palindrome.model.PalindromeData;
import com.example.palindrome.repository.PalindromeDataRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class PalindromeDataServiceImplUnitTest {

  @InjectMocks
  private PalindromeDataServiceImpl palindromeDataService;

  @Mock
  private PalindromeDataRepository palindromeDataRepository;

  @Mock
  private ModelMapper mapper;

  @Test
  public void save_should_use_repository_save_method() {
    PalindromeCalculationRequestDto requestDto = new PalindromeCalculationRequestDto();
    requestDto.setContent("abrakadabra");
    requestDto.setTimestamp(LocalDateTime.now());
    PalindromeData palindromeData = new PalindromeData();
    palindromeData.setContent(requestDto.getContent());
    palindromeData.setTimestamp(requestDto.getTimestamp());

    Mockito.when(mapper.map(requestDto, PalindromeData.class)).thenReturn(palindromeData);

    palindromeDataService.save(requestDto, 3);

    Mockito.verify(palindromeDataRepository, Mockito.times(1)).save(palindromeData);
    Assert.assertEquals(3, palindromeData.getLongestPalindromeSize());
  }
}
