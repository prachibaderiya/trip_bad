package com.prachiBaderiya.project.service;
import com.prachiBaderiya.project.dto.*;
import java.time.LocalDate;

import com.prachiBaderiya.project.dto.TripDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TripService {
TripDto createTrip(TripDto dto);
Page<TripDto> getAllTrips(Pageable pageable);
TripDto getTripById(Long id);
TripDto updateTrip(Long id, TripDto dto);
void deleteTrip(Long id);
Page<TripDto> searchByDestination(String destination, Pageable pageable);
Page<TripDto> filterByStatus(String status, Pageable pageable);
java.util.List<TripDto> getTripsBetween(LocalDate start, LocalDate end);
TripSummaryDto getSummary();
}

