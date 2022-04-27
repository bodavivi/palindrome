package com.example.palindrome.service;

import com.example.palindrome.dto.PalindromeCalculationRequestDto;
import com.example.palindrome.dto.PalindromeDataDto;
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
import java.util.List;

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
    Assert.assertEquals(Integer.valueOf(3), palindromeData.getLongestPalindromeSize());
  }

  @Test
  public void getAll_should_return_all_returned_data_dto_from_repository() {
    PalindromeData data1 = new PalindromeData();
    data1.setTimestamp(LocalDateTime.now().minusDays(1L));
    data1.setLongestPalindromeSize(2);
    data1.setContent("illat");
    data1.setId(1L);
    PalindromeData data2 = new PalindromeData();
    data2.setTimestamp(LocalDateTime.now().plusDays(1L));
    data2.setLongestPalindromeSize(3);
    data2.setContent("kék");
    data2.setId(2L);
    Mockito.when(palindromeDataRepository.findAll()).thenReturn(List.of(data1, data2));

    List<PalindromeDataDto> result = palindromeDataService.getAll();
    Assert.assertEquals(2, result.size());
    Assert.assertEquals(data1.getId(), result.get(0).getId());
    Assert.assertEquals(data1.getContent(), result.get(0).getContent());
    Assert.assertEquals(data1.getTimestamp(), result.get(0).getTimestamp());
    Assert.assertEquals(data1.getLongestPalindromeSize(), result.get(0).getLongestPalindromeSize());
    Assert.assertEquals(data2.getId(), result.get(1).getId());
    Assert.assertEquals(data2.getContent(), result.get(1).getContent());
    Assert.assertEquals(data2.getTimestamp(), result.get(1).getTimestamp());
    Assert.assertEquals(data2.getLongestPalindromeSize(), result.get(1).getLongestPalindromeSize());
  }
}
