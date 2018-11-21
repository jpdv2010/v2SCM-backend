package com.scm.compragames.compragames.controller;

import com.scm.compragames.compragames.data.model.Game;
import com.scm.compragames.compragames.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/game")
public class GameController extends AbstractController<GameService, Game, Long> {

    @Autowired
    public GameController(GameService service) {
        super(service);
    }
}
