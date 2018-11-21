package com.scm.compragames.compragames.controller;

import com.scm.compragames.compragames.data.model.Purchase;
import com.scm.compragames.compragames.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/purchase")
public class PurchaseController extends AbstractController<PurchaseService, Purchase, Long>  {

    @Autowired
    public PurchaseController(PurchaseService service) {
        super(service);
    }
}
