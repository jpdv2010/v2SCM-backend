package com.scm.compragames.compragames.service.implementation;

import com.scm.compragames.compragames.data.model.User;
import com.scm.compragames.compragames.data.repository.UserRepository;
import com.scm.compragames.compragames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation extends AbstractServiceImplementation<UserRepository, User, Long> implements UserService {

    @Autowired
    protected UserServiceImplementation(UserRepository repository) {
        super(repository);
    }

    @Override
    protected void updateEntity(User objToSave, User objParam) {

    }
}
