package com.scm.compragames.compragames.data.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "INVENTORY_GAME")
@Entity
public class InventoryGame extends BaseModel implements Serializable {

    @JoinColumn(foreignKey = @ForeignKey(name = "FK_GAME_INVENTORY_ID"), name = "INVENTORY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Inventory inventory;

    @JoinColumn(foreignKey = @ForeignKey(name = "FK_INVENTORY_GAME_ID"), name = "GAME_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Game game;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
