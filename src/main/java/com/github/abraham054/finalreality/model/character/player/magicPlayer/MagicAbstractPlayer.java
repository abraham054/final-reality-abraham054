package com.github.abraham054.finalreality.model.character.player.magicPlayer;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.AbstractPlayerCharacter;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

public abstract class MagicAbstractPlayer extends AbstractPlayerCharacter {
    private final int mana;

    /**
     * Creates a new  magic character.
     *
     * @param name          the character's name
     * @param turnsQueue    the queue with the characters waiting for their turn
     * @param defense       the character's defense
     * @param healthPoints  the character's health points
     * @param mana          the character's mana
     */
    public MagicAbstractPlayer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                               int defense, int healthPoints, int mana){
        super(turnsQueue, name,defense,healthPoints);
        this.mana = mana;
    }

    /**
     * Returns the character's mana
     *  */
    public int getMana() {
        return this.mana;
    }

    /**
     * Returns a list with the magic player stats (name, defense, health points, mana and weapon if equipped).
     */
    @Override
    public LinkedList<String> getStats(){
        LinkedList<String> stats = new LinkedList<>();
        stats.add(getName());
        stats.add("Defense: " + String.valueOf(getDefense()));
        stats.add("Health points: " + String.valueOf(getHealthPoints()));
        stats.add("Mana: " + String.valueOf(getMana()));
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
        if (!(o instanceof MagicAbstractPlayer)) {
            return false;
        }
        final MagicAbstractPlayer that = (MagicAbstractPlayer) o;
        return that.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), MagicAbstractPlayer.class, getEquippedWeapon());
    }
}
