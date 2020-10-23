package com.github.abraham054.finalreality.model.character.player.commonPlayer.commonClasses;

import com.github.abraham054.finalreality.model.character.ICharacter;
import com.github.abraham054.finalreality.model.character.player.commonPlayer.CommonPlayer;
import com.github.abraham054.finalreality.model.character.player.playerClasses.CommonPlayerClass;
import com.github.abraham054.finalreality.model.weapon.weaponTypes.CommonWeaponType;
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
    public Knight(@NotNull String name, @NotNull BlockingQueue<ICharacter> turnsQueue, int defense, int healthPoints) {
        super(name, turnsQueue, defense, healthPoints,CommonPlayerClass.KNIGHT);
    }

    /**
     * Returns true if the character can equip the weapon
     * */
    @Override
    public boolean correctWeapon(Weapon weapon) {
        boolean isSword = (weapon.getType() == CommonWeaponType.SWORD);
        boolean isAxe = (weapon.getType() == CommonWeaponType.AXE);
        boolean isKnife = (weapon.getType() == CommonWeaponType.KNIFE);
        return (isAxe || isSword || isKnife) && this.getHealthPoints() > 0;
    }
}
