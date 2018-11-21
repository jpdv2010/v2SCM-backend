package com.scm.compragames.compragames.service.implementation;

import com.scm.compragames.compragames.data.model.Purchase;
import com.scm.compragames.compragames.data.repository.PurchaseRepository;
import com.scm.compragames.compragames.service.PurchaseGameService;
import com.scm.compragames.compragames.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImplementation extends AbstractServiceImplementation<PurchaseRepository, Purchase, Long> implements PurchaseService {

    @Autowired
    protected PurchaseServiceImplementation(PurchaseRepository repository) {
        super(repository);
    }

    @Override
    protected void updateEntity(Purchase objToSave, Purchase objParam) {

    }
}
