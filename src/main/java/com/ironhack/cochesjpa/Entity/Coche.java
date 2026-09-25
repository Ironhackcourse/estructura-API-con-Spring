package com.ironhack.cochesjpa.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @ManyToOne
    @JoinColumn(name = "id_marca")
    @JsonBackReference
    private Marca marcaId;

    @Column(nullable = false)
    private String modelo;

     @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    private double precio;
}
