package com.luankuhlmann.gamelist.controllers;

import com.luankuhlmann.gamelist.dto.GameMinDTO;
import com.luankuhlmann.gamelist.entities.Game;
import com.luankuhlmann.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameservice;

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameservice.findAll();
        return result;
    }
}
