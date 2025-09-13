package com.prachiBaderiya.project.controller;
import com.prachiBaderiya.project.service.*;
import com.prachiBaderiya.project.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/api/trips")
@RequiredArgsConstructor
public class TripController {
private final TripService service;
@PostMapping
public ResponseEntity<TripDto> create(@RequestBody TripDto dto){
return ResponseEntity.ok(service.createTrip(dto));
}
@GetMapping
public ResponseEntity<Page<TripDto>> getAll(
@RequestParam(defaultValue = "0") int page,
@RequestParam(defaultValue = "10") int size,
@RequestParam(defaultValue = "id,asc") String[] sort) {
String sortBy = sort[0];
Sort.Direction dir = sort.length > 1 &&
"desc".equalsIgnoreCase(sort[1]) ? Sort.Direction.DESC : Sort.Direction.ASC;
Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortBy));
return ResponseEntity.ok(service.getAllTrips(pageable));
}
@GetMapping("/{id}")
public ResponseEntity<TripDto> getById(@PathVariable Long id){

return ResponseEntity.ok(service.getTripById(id));
}
@PutMapping("/{id}")
public ResponseEntity<TripDto> update(@PathVariable Long id, @RequestBody
TripDto dto){
return ResponseEntity.ok(service.updateTrip(id, dto));
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable Long id){
service.deleteTrip(id);
return ResponseEntity.noContent().build();
}
@GetMapping("/search")
public ResponseEntity<Page<TripDto>> search(@RequestParam String
destination,
@RequestParam(defaultValue =
"0") int page,
@RequestParam(defaultValue =
"10") int size){
Pageable p = PageRequest.of(page, size);
return ResponseEntity.ok(service.searchByDestination(destination, p));
}
@GetMapping("/filter")
public ResponseEntity<Page<TripDto>> filter(@RequestParam String status,
@RequestParam(defaultValue =
"0") int page,
@RequestParam(defaultValue =
"10") int size){
Pageable p = PageRequest.of(page, size);
return ResponseEntity.ok(service.filterByStatus(status, p));
}
@GetMapping("/daterange")
public ResponseEntity<List<TripDto>> dateRange(
@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
LocalDate start,
@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
LocalDate end){
return ResponseEntity.ok(service.getTripsBetween(start, end));
}
@GetMapping("/summary")
public ResponseEntity<TripSummaryDto> summary(){
return ResponseEntity.ok(service.getSummary());

}
}