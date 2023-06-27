package com.example.demos;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.time.Instant;

@Entity
public class Todo extends PanacheEntity {

    public String description;

    public String details;

    public boolean done;

    public Instant createdAt = Instant.now();

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id + '\'' +
                ", description='" + description + '\'' +
                ", details='" + details + '\'' +
                ", done=" + done +
                ", createdAt=" + createdAt +
                '}';
    }
}