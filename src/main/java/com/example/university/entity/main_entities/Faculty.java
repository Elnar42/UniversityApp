package com.example.university.entity.main_entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Faculty extends MainEntity {

    private String name;
    private String surname;

    private int age;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

}
