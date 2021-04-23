package com.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
 
import javax.persistence.*;
import java.time.LocalDate;
 
@Entity
@Table(name = "userpoc5")

@Data

@Builder

@NoArgsConstructor

@AllArgsConstructor
@Component
public class User {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "firstName", nullable = false)
    String FirstName;
    @Column(name = "lastName", nullable = false)
    String LastName;
    @Column(name = "contact", nullable = false)
    Long contact;
    @Column(name = "email_address", nullable = false, unique = true)
    String email;
    @Column(name = "City")
    String city;
    @Column(name = "Country")
    String country;
   
 
}