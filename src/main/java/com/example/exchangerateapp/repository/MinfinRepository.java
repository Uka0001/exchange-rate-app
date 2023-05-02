package com.example.exchangerateapp.repository;

import com.example.exchangerateapp.model.MinfinRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinfinRepository extends JpaRepository<MinfinRate, Long> {
}
