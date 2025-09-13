package com.prachiBaderiya.project.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripDto {
private Long id;
private String destination;
private LocalDate startDate;
private LocalDate endDate;
private Double price;
private String status;
}