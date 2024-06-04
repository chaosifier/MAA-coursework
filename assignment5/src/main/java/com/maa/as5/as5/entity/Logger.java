package com.maa.as5.as5.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactio_id")
    private int transactionId;

    private LocalDate date;
    private LocalTime time;
    private String principle;
    private String operation;

    public Logger() {
    }

    public Logger(LocalDate date, LocalTime time, String principle, String operation) {
        this.date = date;
        this.time = time;
        this.principle = principle;
        this.operation = operation;
    }
}
