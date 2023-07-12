package com.luankuhlmann.gamelist.repositories;

import com.luankuhlmann.gamelist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}

