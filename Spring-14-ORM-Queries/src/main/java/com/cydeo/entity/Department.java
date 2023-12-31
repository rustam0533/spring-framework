package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Target;

@Entity
@Table(name="departments")
@Data
@NoArgsConstructor
public class Department  {
    @Id
    private String department;
    private String division;
}
