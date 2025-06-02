package com.jt.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
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
    @Min(100)
    private int roll;

    @NotEmpty
    @NotNull
    @NotBlank
    private String nam;

    @NotEmpty
    @NotNull
    @NotBlank
    @Email(message = "Email should be valid")
    private String email;

    @PositiveOrZero
    // @Digits(integer = 10, fraction = 2, message = "Fees should be a positive
    // number with up to two decimal places")
    private double fees;

    @NotEmpty
    @NotNull
    @NotBlank
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Phone number should be a valid Indian mobile number")
    private String phoneNumber;

}
