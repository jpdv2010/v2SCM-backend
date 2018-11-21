package com.scm.compragames.compragames.service.implementation;

import com.scm.compragames.compragames.data.model.PurchaseGame;
import com.scm.compragames.compragames.data.repository.PurchaseGameRepository;
import com.scm.compragames.compragames.service.PurchaseGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseGameServiceImplementation extends AbstractServiceImplementation<PurchaseGameRepository, PurchaseGame, Long> implements PurchaseGameService {

    @Autowired
    protected PurchaseGameServiceImplementation(PurchaseGameRepository repository) {
        super(repository);
    }

    @Override
    protected void updateEntity(PurchaseGame objToSave, PurchaseGame objParam) {

    }
}
