package com.scm.compragames.compragames.service.implementation;

import com.scm.compragames.compragames.data.model.Inventory;
import com.scm.compragames.compragames.data.repository.InventoryRepository;
import com.scm.compragames.compragames.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImplementation extends AbstractServiceImplementation<InventoryRepository, Inventory, Long> implements InventoryService {

    @Autowired
    protected InventoryServiceImplementation(InventoryRepository repository) {
        super(repository);
    }

    @Override
    protected void updateEntity(Inventory objToSave, Inventory objParam) {

    }
}
