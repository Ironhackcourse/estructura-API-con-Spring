package com.ironhack.cochesjpa.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor 
@NoArgsConstructor 
@Entity
@Getter 
@Setter 
@Table(name = "marca")
public class Marca {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_marca")
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;


    @OneToMany(mappedBy = "marcaId", cascade = CascadeType.ALL)
     @JsonManagedReference
    private List<Coche> coches = new ArrayList<>();

}