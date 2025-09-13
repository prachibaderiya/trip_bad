package com.prachiBaderiya.project.entity;

import java.time.LocalDate;
import com.prachiBaderiya.project.entity.Status;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDate;


@Entity
@Table(name = "trips")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trip {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@NotBlank
private String destination;


@NotNull
private LocalDate startDate;


@NotNull
private LocalDate endDate;


@NotNull
private Double price;


@Enumerated(EnumType.STRING)
private Status status;
}
