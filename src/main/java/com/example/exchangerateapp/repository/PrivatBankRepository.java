package com.example.exchangerateapp.repository;

import com.example.exchangerateapp.model.PrivatBankRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivatBankRepository extends JpaRepository<PrivatBankRate, Long> {
}
