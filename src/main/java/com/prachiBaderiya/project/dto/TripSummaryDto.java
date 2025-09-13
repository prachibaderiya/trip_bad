package com.prachiBaderiya.project.dto;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripSummaryDto {
    private Long totalTrips;
    private Double minPrice;
    private Double maxPrice;
    private Double averagePrice;
}
