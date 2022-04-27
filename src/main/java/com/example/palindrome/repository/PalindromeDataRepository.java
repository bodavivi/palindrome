package com.example.palindrome.repository;

import com.example.palindrome.model.PalindromeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeDataRepository extends JpaRepository<PalindromeData, Long> {
}
