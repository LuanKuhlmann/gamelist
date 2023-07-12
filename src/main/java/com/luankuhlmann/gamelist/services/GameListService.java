package com.luankuhlmann.gamelist.services;

import com.luankuhlmann.gamelist.dto.GameDTO;
import com.luankuhlmann.gamelist.dto.GameListDTO;
import com.luankuhlmann.gamelist.dto.GameMinDTO;
import com.luankuhlmann.gamelist.entities.Game;
import com.luankuhlmann.gamelist.entities.GameList;
import com.luankuhlmann.gamelist.repositories.GameListRepository;
import com.luankuhlmann.gamelist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
