package com.alex.pruebagit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alex.pruebagit.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    
}
