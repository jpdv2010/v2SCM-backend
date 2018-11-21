package com.scm.compragames.compragames.controller;

import com.scm.compragames.compragames.data.model.PurchaseGame;
import com.scm.compragames.compragames.data.model.User;
import com.scm.compragames.compragames.service.PurchaseGameService;
import com.scm.compragames.compragames.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController  extends AbstractController<UserService, User, Long> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }
}
