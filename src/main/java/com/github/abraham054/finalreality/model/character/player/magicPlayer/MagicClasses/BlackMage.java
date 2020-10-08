package com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicClasses;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicPlayer;
import com.github.abraham054.finalreality.model.character.player.magicPlayer.MagicPlayerClass;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponType.CommonWeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class BlackMage extends MagicPlayer {
    /**
     * Creates a new character.
     *
     * @param name         the character's name
     * @param turnsQueue   the queue with the characters waiting for their turn
     * @param defense      the character's defense
     * @param healthPoints the character's health points
     * @param mana         the character's mana
     */
    public BlackMage(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int defense, int healthPoints, int mana) {
        super(name, turnsQueue, defense, healthPoints, mana);
        this.magicClass = MagicPlayerClass.BLACK_MAGE;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        boolean isKnife = (weapon.getType() == CommonWeaponType.KNIFE);

        if( isKnife ){
            equippedWeapon = weapon;
        }
    }
}
