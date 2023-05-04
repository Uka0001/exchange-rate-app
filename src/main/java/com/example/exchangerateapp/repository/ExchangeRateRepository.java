package com.example.exchangerateapp.repository;

import com.example.exchangerateapp.dto.ResultRateDto;
import com.example.exchangerateapp.model.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    @Query(value = "SELECT currency_code, avg(buy) AS buy, avg(sale) AS sale "
            + "FROM exchange_rates e "
            + "WHERE sale > 1.5 and buy > 1.5 "
            + "GROUP BY currency_code "
            + "ORDER BY currency_code", nativeQuery = true)
    List<Object[]> findAllAverageRates();

    @Query(value = "SELECT currency_code, avg(buy) AS buy, avg(sale) AS sale "
            + "FROM exchange_rates e "
            + "WHERE sale > 1.5 and buy > 1.5 "
            + "AND date >= ?1 AND date <= ?2 "
            + "GROUP BY currency_code "
            + "ORDER BY currency_code", nativeQuery = true)
    List<Object[]> findAllAverageRatesByPeriod(LocalDate startDate, LocalDate endDate);
}
