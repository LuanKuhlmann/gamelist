package com.luankuhlmann.gamelist.services;

import com.luankuhlmann.gamelist.dto.GameMinDTO;
import com.luankuhlmann.gamelist.entities.Game;
import com.luankuhlmann.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
