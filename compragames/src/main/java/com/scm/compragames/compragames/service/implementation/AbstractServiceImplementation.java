package com.scm.compragames.compragames.service.implementation;

import com.scm.compragames.compragames.data.model.BaseModel;
import com.scm.compragames.compragames.data.repository.ParenthoodRepository;
import com.scm.compragames.compragames.service.AbstractService;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;

public abstract class AbstractServiceImplementation <T extends ParenthoodRepository<Y, Z>, Y extends BaseModel, Z extends Serializable>
        implements AbstractService<Y, Z> {
    protected T repository;

    protected AbstractServiceImplementation(T repository) {
        this.repository = repository;
    }

    @Override
    public Y findById(Z id) throws NotFoundException {

        Optional<Y> obj = repository.findById(id);
        if (!obj.isPresent()) {
            throw new NotFoundException("Registro não encontrado.");
        }

        return obj.get();
    }

    @Override
    public Collection<Y> findAll() throws Exception {
        List<Y> all = repository.findAll();
        return CollectionUtils.isEmpty(all) ? Collections.emptyList() : all;
    }

    @Override
    public Collection<Y> findAllByActiveTrue() throws Exception {
        List<Y> all = repository.findAll();
        return all == null ? Collections.emptyList() : all;
    }

    @Override
    public Y disable(Z id) throws NotFoundException {
        Y obj = this.findById(id);
        obj.setActive(Boolean.FALSE);
        repository.save(obj);
        return obj;
    }

    @Override
    @Transactional(rollbackFor = { Exception.class, Exception.class, RuntimeException.class })
    public Y save(Y obj) throws Exception {

        // - validate if exists object
        if (obj == null) {
            throw new Exception("Objeto vazio.");
        }

        // - prepare object
        Y objAux = this.prepare(obj);

        // - backup status
        boolean active = obj.getActive();

        // - check field updates
        this.checkEntityUpdate(objAux);

        // - apply field updates
        this.applyEntityUpdate(objAux, obj);

        // - check object
        this.check(objAux, active);

        // - try to save
        obj = repository.save(objAux);

        return afterSave(obj);
    }

    @SuppressWarnings("unchecked")
    Y prepare(Y obj) throws NotFoundException {

        Y auxObj = obj;
        if (obj.getId() != null) {
            auxObj = this.findById((Z) obj.getId());
        }

        return auxObj;
    }

    /**
     * This can be implemented, and will call after save object.
     **/
    protected Y afterSave(Y persisted) throws Exception {
        return persisted;
    }

    /**
     * This can be implemented in extending service to add validations to final object.
     **/
    protected void checkEntityUpdate(Y objToSave) throws Exception {

        /* throws a exception if the object save shall not pass :D */

    }

    protected boolean isNewEntity(Y objToSave) {
        return objToSave.getId() == null;
    }

    protected void applyEntityUpdate(Y objAux, Y obj) throws Exception {

        updateEntity(objAux, obj);
        validateEntity(objAux);
        postValidationUpdate(objAux, obj);

    }

    protected void check(Y obj, boolean active) throws Exception{

        if (isNewEntity(obj)) {
            this.checkNewEntity(obj);
        } else {
            this.checkUpdateEntity(obj, active);
        }

    }

    protected void checkNewEntity(Y obj) {

        obj.setActive(true);

    }

    /* make this protected if you wanna Override that someday */
    private void checkUpdateEntity(Y obj, boolean active) {

        this.checkNewEntity(obj);
        obj.setActive(active);

    }

    /**
     * This can be implemented in extending service to add validations to final object
     **/
    protected void validateEntity(Y objToSave) throws Exception {

        /* throws a exception if the object save shall not pass :D */

    }

    /**
     * Needs to be implemented by extending service class
     **/
    protected abstract void updateEntity(Y objToSave, Y objParam);

    /**
     * updates an entity after validating it, good for treating data before
     * persisting it in the database (e.g. encryption)
     *
     * @param objToSave if updated, from database, else objParam
     * @param objParam user input
     **/
    protected void postValidationUpdate(Y objToSave, Y objParam) throws Exception{ }

}
