package com.github.abraham054.finalreality.model.character.player.CommonPlayer.CommonClasses;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.CommonPlayer.CommonPlayer;
import com.github.abraham054.finalreality.model.character.player.PlayerClasses.CommonPlayerClass;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.*;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.BlockingQueue;

public class Thief extends CommonPlayer {
    /**
     * Creates a new common character.
     *
     * @param name         the character's name
     * @param turnsQueue   the queue with the characters waiting for their turn
     * @param defense      the character's defense
     * @param healthPoints the character's health points
     */
    public Thief(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int defense, int healthPoints) {
        super(name, turnsQueue, defense, healthPoints,CommonPlayerClass.THIEF);
    }

    /**
     * Returns true if the character can equip the weapon
     * */
    @Override
    public boolean correctWeapon(Weapon weapon) {
        boolean isSword = (weapon.getType() == CommonWeaponType.SWORD);
        boolean isBow = (weapon.getType() == CommonWeaponType.BOW);
        boolean isStaff = (weapon.getType() == MagicWeaponType.STAFF);
        return (isSword || isBow || isStaff) && this.getHealthPoints() > 0;
    }

}
