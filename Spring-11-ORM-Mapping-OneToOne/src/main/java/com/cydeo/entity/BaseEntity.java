package com.cydeo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass   // which means we will use this class only for inheritance as parent
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // hibernate handles creation of ids automatically
    private int id;  // primary key
}
