package com.luankuhlmann.gamelist.repositories;

import com.luankuhlmann.gamelist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
