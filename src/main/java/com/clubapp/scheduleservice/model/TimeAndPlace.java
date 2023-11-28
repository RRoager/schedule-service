package com.clubapp.scheduleservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class TimeAndPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location;
    private String day;
    @ManyToOne
    @JoinColumn(name="schedule_id", nullable=false)
    private Schedule schedule;
}
