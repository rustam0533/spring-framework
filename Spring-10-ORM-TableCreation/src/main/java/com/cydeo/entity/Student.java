package com.cydeo.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="studentFirstName")
    private String firstName;
    @Column(name="studentLastName")
    private String lastName;
    private String email;
    @Transient
    private String city;
    @Column(columnDefinition = "DATE")
    private LocalDate birthdate;
    @Column(columnDefinition = "TIME")

    private LocalDate birthDateTime;
    @Column(columnDefinition = "TIMESTAMP")

    private LocalDate birthtime;
@Enumerated(EnumType.STRING)
    private Gender gender;

}
