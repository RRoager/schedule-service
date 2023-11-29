package com.clubapp.scheduleservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
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
    @CreationTimestamp(source = SourceType.DB)
    private Instant createdOn;
    @UpdateTimestamp(source = SourceType.DB)
    private Instant lastUpdatedOn;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<TimeAndPlace> timeAndPlaces;
    @OneToOne(mappedBy = "schedule", cascade = CascadeType.ALL)
    private Season season;
}