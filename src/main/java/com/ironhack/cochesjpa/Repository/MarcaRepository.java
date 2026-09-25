package com.ironhack.cochesjpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ironhack.cochesjpa.Entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
    
}
