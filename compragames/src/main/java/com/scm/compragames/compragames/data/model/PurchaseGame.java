package com.scm.compragames.compragames.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "PURCHASE_GAME")
@Entity
public class PurchaseGame extends BaseModel implements Serializable {

    @JoinColumn(foreignKey = @ForeignKey(name = "FK_PURCHASE_GAME_ID"), name = "GAME_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Game game;

    @JoinColumn(foreignKey = @ForeignKey(name = "FK_GAME_PURCHASE_ID"), name = "PURCHASE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Purchase purchase;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
