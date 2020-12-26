package com.github.abraham054.finalreality.model.character.player.commonPlayer;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public abstract class CommonAbstractPlayer extends AbstractPlayerCharacter {

    /**
     * Creates a new common character.
     *
     * @param name          the character's name
     * @param turnsQueue    the queue with the characters waiting for their turn
     * @param defense       the character's defense
     * @param healthPoints  the character's health points
     */
    protected CommonAbstractPlayer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                                   int defense, int healthPoints){
        super(turnsQueue, name,defense,healthPoints);
    }

    @Override
    public LinkedList<String> getStats(){
        LinkedList<String> stats = new LinkedList<>();
        stats.add(getName());
        stats.add("Defense: " + String.valueOf(getDefense()));
        stats.add("Health points: " + String.valueOf(getHealthPoints()));
        if(equippedWeapon != null){
            stats.add("Arma: " + equippedWeapon.getName());
        }
        return stats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommonAbstractPlayer)) {
            return false;
        }
        final CommonAbstractPlayer that = (CommonAbstractPlayer) o;
        return that.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), CommonAbstractPlayer.class, getEquippedWeapon());
    }

}
