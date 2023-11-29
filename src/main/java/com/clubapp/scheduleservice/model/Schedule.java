package com.clubapp.scheduleservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long activityId;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<TimeAndPlace> timeAndPlaces;
    @OneToOne(mappedBy = "schedule", cascade = CascadeType.ALL)
    private Season season;
}