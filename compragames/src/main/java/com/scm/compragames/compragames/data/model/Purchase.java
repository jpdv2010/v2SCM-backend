package com.scm.compragames.compragames.data.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "PURCHASE")
@Entity
public class Purchase extends BaseModel implements Serializable {
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_PURCHASE_USER_ID"), name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BOUGHT_AT")
    private Date boughtAt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBoughtAt() {
        return boughtAt;
    }

    public void setBoughtAt(Date boughtAt) {
        this.boughtAt = boughtAt;
    }
}
