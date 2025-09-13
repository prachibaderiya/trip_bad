package com.prachiBaderiya.project.repository;
import com.prachiBaderiya.project.entity.Status;
import com.prachiBaderiya.project.entity.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;
public interface TripRepository extends JpaRepository<Trip, Long> {
Page<Trip> findByDestinationContainingIgnoreCase(String destination, Pageable pageable);
Page<Trip> findByStatus(Status status, Pageable pageable);
List<Trip> findByStartDateBetween(LocalDate start, LocalDate end);


@Query("SELECT COUNT(t), MIN(t.price), MAX(t.price), AVG(t.price) FROM Trip t")
Object[] getSummaryRaw();
}