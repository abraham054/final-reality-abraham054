package com.github.abraham054.finalreality.model.character.player.magicPlayer;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.weapon.IWeapon;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;

public class BlackMage extends MagicAbstractPlayer {
    /**
     * Creates a new Black mage.
     *
     * @param name         the character's name
     * @param turnsQueue   the queue with the characters waiting for their turn
     * @param defense      the character's defense
     * @param healthPoints the character's health points
     * @param mana         the character's mana
     */
    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                     int defense, int healthPoints, int mana) {
        super(name, turnsQueue, defense, healthPoints, mana);
    }

    /**
     * Equips a Black mage's viable weapon, if it got equipped returns true else returns false.
     */
    @Override
    public boolean equipWeapon(IWeapon weapon) {
        if(weapon.canEquipBlackMage() && healthPoints > 0){
            this.equippedWeapon = weapon;
            return true;
        } else return false;
    }
}
