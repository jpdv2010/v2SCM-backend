package com.scm.compragames.compragames.controller;

import com.scm.compragames.compragames.data.model.PurchaseGame;
import com.scm.compragames.compragames.service.PurchaseGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/purchase-game")
public class PurchaseGameController extends AbstractController<PurchaseGameService, PurchaseGame, Long>  {

    @Autowired
    public PurchaseGameController(PurchaseGameService service) {
        super(service);
    }
}
