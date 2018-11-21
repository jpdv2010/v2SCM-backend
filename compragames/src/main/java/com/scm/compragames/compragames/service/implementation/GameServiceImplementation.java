package com.scm.compragames.compragames.service.implementation;

import com.scm.compragames.compragames.data.model.Game;
import com.scm.compragames.compragames.data.repository.GameRepository;
import com.scm.compragames.compragames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImplementation extends AbstractServiceImplementation<GameRepository, Game, Long> implements GameService {

    @Autowired
    protected GameServiceImplementation(GameRepository repository) {
        super(repository);
    }

    @Override
    protected void updateEntity(Game objToSave, Game objParam) {

    }
}
