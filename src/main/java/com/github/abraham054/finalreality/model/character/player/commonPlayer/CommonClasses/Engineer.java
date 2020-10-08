package com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonPlayer;
import com.github.abraham054.finalreality.model.character.player.PlayerClasses.CommonPlayerClass;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Engineer extends CommonPlayer {
    /**
     * Creates a new common character.
     *
     * @param name         the character's name
     * @param turnsQueue   the queue with the characters waiting for their turn
     * @param defense      the character's defense
     * @param healthPoints the character's health points
     */
    public Engineer(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue,
                       int defense, int healthPoints) {
        super(name, turnsQueue, defense, healthPoints,CommonPlayerClass.ENGINEER);
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        boolean isAxe = (weapon.getType() == CommonWeaponType.AXE);
        boolean isBow = (weapon.getType() == CommonWeaponType.BOW);

        if(isAxe || isBow){
            equippedWeapon = weapon;
        }
    }
}
