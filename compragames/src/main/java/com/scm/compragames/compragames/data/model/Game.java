package com.scm.compragames.compragames.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "GAME")
public class Game extends BaseModel implements Serializable {

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
