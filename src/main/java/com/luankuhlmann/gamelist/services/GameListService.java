package com.luankuhlmann.gamelist.services;

import com.luankuhlmann.gamelist.dto.GameListDTO;
import com.luankuhlmann.gamelist.entities.GameList;
import com.luankuhlmann.gamelist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex; //Função ternaria
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex; //Função ternaria

        for(int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
