package com.jt.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {                                                                                        
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String studentid;

    @Positive
    private int roll;

    private String nam;
    
    private String email;

    private double fees;

    private String phoneNumber;
    
}
