package com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonClasses;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonPlayer;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonPlayerClass;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.WeaponType.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.*;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.BlockingQueue;


public class Knight extends CommonPlayer {
    /**
     * Creates a new common character.
     *
     * @param name         the character's name
     * @param turnsQueue   the queue with the characters waiting for their turn
     * @param defense      the character's defense
     * @param healthPoints the character's health points
     */
    protected Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int defense, int healthPoints) {
        super(name, turnsQueue, defense, healthPoints);
        this.commonClass = CommonPlayerClass.KNIGHT;
    }

    @Override
    public void equipWeapon(Weapon weapon) {
        boolean isSword = (weapon.getType() == CommonWeaponType.SWORD);
        boolean isAxe = (weapon.getType() == CommonWeaponType.AXE);
        boolean isKnife = (weapon.getType() == CommonWeaponType.KNIFE);

        if(isAxe || isSword || isKnife){
            equippedWeapon = weapon;
        }
    }
}
