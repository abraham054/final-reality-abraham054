package com.github.abraham054.finalreality.model.character.player.commonPlayer;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

public class Engineer extends CommonAbstractPlayer {
    /**
     * Creates a new Engineer.
     *
     * @param name         the character's name
     * @param turnsQueue   the queue with the characters waiting for their turn
     * @param defense      the character's defense
     * @param healthPoints the character's health points
     */
    public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                       int defense, int healthPoints) {
        super(name, turnsQueue, defense, healthPoints);
    }

    /**
     * Equips an Engineer's viable weapon, if it got equipped returns true else returns false.
     */
    @Override
    public boolean equipWeapon(IWeapon weapon) {
        if(weapon.canEquipEngineer() && healthPoints > 0){
            this.equippedWeapon = weapon;
            return true;
        } else return false;
    }
}
