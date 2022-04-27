package com.example.palindrome.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table
public class PalindromeData {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @Column(name = "content")
  private String content;

  @Column(name = "timestamp")
  private LocalDateTime timestamp;

  @Column(name = "longest_palindrome_size")
  private int longestPalindromeSize;

}
