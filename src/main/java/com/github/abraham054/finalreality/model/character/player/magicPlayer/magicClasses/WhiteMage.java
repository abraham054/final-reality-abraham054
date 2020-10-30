package com.github.abraham054.finalreality.model.character.player.MagicPlayer.MagicClasses;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.MagicPlayer.MagicPlayer;
import com.github.abraham054.finalreality.model.character.player.PlayerClasses.MagicPlayerClass;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class WhiteMage extends MagicPlayer {
    /**
     * Creates a new character.
     *
     * @param name         the character's name
     * @param turnsQueue   the queue with the characters waiting for their turn
     * @param defense      the character's defense
     * @param healthPoints the character's health points
     * @param mana         the character's mana
     */
    public WhiteMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                     int defense, int healthPoints, int mana) {
        super(name, turnsQueue, defense, healthPoints, mana,MagicPlayerClass.WHITE_MAGE);
    }

    /**
     * Returns true if the character can equip the weapon
     * */
    @Override
    public boolean correctWeapon(Weapon weapon) {
        boolean isStaff = (weapon.getType() == MagicWeaponType.STAFF);
        return isStaff && this.getHealthPoints() > 0;
    }
}
