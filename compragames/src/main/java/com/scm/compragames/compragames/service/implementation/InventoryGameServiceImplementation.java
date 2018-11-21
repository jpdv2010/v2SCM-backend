package com.scm.compragames.compragames.service.implementation;

import com.scm.compragames.compragames.data.model.InventoryGame;
import com.scm.compragames.compragames.data.repository.InventoryGameRepository;
import com.scm.compragames.compragames.service.InventoryGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryGameServiceImplementation extends AbstractServiceImplementation<InventoryGameRepository, InventoryGame, Long> implements InventoryGameService {

    @Autowired
    protected InventoryGameServiceImplementation(InventoryGameRepository repository) {
        super(repository);
    }

    @Override
    protected void updateEntity(InventoryGame objToSave, InventoryGame objParam) {

    }
}
