package com.prachiBaderiya.project.serviceImpl;
import java.time.LocalDate;
import java.util.stream.Collectors;
import com.prachiBaderiya.project.repository.*;
import com.prachiBaderiya.project.exception.*;

import com.prachiBaderiya.project.dto.TripDto;
import com.prachiBaderiya.project.dto.TripSummaryDto;
import com.prachiBaderiya.project.entity.Status;
import com.prachiBaderiya.project.entity.Trip;
import com.prachiBaderiya.project.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

private final TripRepository repo;
private TripDto toDto(Trip t){
return TripDto.builder()
.id(t.getId())
.destination(t.getDestination())
.startDate(t.getStartDate())
.endDate(t.getEndDate())
.price(t.getPrice())
.status(t.getStatus() != null ? t.getStatus().name() : null)
.build();
}


private Trip toEntity(TripDto d){
return Trip.builder()
.destination(d.getDestination())
.startDate(d.getStartDate())
.endDate(d.getEndDate())
.price(d.getPrice())
.status(d.getStatus() != null ? Status.valueOf(d.getStatus()) : Status.PLANNED)
.build();
}


@Override
public TripDto createTrip(TripDto dto) {
Trip t = toEntity(dto);
Trip saved = repo.save(t);
return toDto(saved);
}

@Override
public Page<TripDto> getAllTrips(Pageable pageable) {
return repo.findAll(pageable).map(this::toDto);
}
public TripDto getTripById(Long id) {
Trip t = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trip not found"));
return toDto(t);
}


@Override
public TripDto updateTrip(Long id, TripDto dto) {
Trip t = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trip not found"));
t.setDestination(dto.getDestination());
t.setStartDate(dto.getStartDate());
t.setEndDate(dto.getEndDate());
t.setPrice(dto.getPrice());
t.setStatus(dto.getStatus() != null ? Status.valueOf(dto.getStatus()) : t.getStatus());
return toDto(repo.save(t));
}


@Override
public void deleteTrip(Long id) {
repo.deleteById(id);
}


@Override
public Page<TripDto> searchByDestination(String destination, Pageable pageable) {
return repo.findByDestinationContainingIgnoreCase(destination, pageable).map(this::toDto);
}


@Override
public Page<TripDto> filterByStatus(String status, Pageable pageable) {
Status s = Status.valueOf(status);
return repo.findByStatus(s, pageable).map(this::toDto);
}


@Override
public List<TripDto> getTripsBetween(LocalDate start, LocalDate end) {
return repo.findByStartDateBetween(start, end).stream().map(this::toDto).collect(Collectors.toList());
}


@Override
public TripSummaryDto getSummary() {
Object[] arr = repo.getSummaryRaw();
Long total = (Long)arr[0];
Double min = (Double) arr[1];
Double max = (Double) arr[2];
Double avg = (Double) arr[3];
return new TripSummaryDto(total, min, max, avg);
}

}
