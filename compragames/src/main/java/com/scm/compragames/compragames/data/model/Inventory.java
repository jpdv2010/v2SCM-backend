package com.scm.compragames.compragames.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "INVENTORY")
@Entity
public class Inventory extends BaseModel implements Serializable {

    @JoinColumn(foreignKey = @ForeignKey(name = "FK_INVENTORY_USER_ID"), name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
