package com.scm.compragames.compragames.controller;

import com.scm.compragames.compragames.data.model.Inventory;
import com.scm.compragames.compragames.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController extends AbstractController<InventoryService, Inventory, Long>  {

    @Autowired
    public InventoryController(InventoryService service) {
        super(service);
    }
}
