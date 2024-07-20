package com.example.university.entity.main_entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Staff extends MainEntity {


    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
