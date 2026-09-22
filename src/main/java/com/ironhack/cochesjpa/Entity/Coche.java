package com.ironhack.cochesjpa.Entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor 
@NoArgsConstructor 
@Entity
@Getter 
@Setter 
@Table(name = "coche")
public class Coche {

    @Id 
    @Column(name = "id_coche")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

     @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    private double precio;
}
