package com.scm.compragames.compragames.controller;

import com.scm.compragames.compragames.data.model.InventoryGame;
import com.scm.compragames.compragames.service.InventoryGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/inventory-game")
public class InventoryGameController extends AbstractController<InventoryGameService, InventoryGame, Long>  {

    @Autowired
    public InventoryGameController(InventoryGameService service) {
        super(service);
    }
}
