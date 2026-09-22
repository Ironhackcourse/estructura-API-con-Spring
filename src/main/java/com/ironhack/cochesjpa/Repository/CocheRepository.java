package com.ironhack.cochesjpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ironhack.cochesjpa.Entity.Coche;

public interface CocheRepository extends JpaRepository<Coche, Long> {

}
