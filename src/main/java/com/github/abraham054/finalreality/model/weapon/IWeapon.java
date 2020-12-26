package com.github.abraham054.finalreality.model.weapon;

import com.github.abraham054.finalreality.utils.weaponStates.WeaponState;

import java.util.LinkedList;

public interface IWeapon {

    /**
     * Returns the weapon's name
     * */
    String getName();

    LinkedList<String> getStats();

    void unEquip();

    void equip();

    boolean getIfAvailable();

    WeaponState getWeaponState();

    /**
     * Returns the weapon's damage
     * */
    int getDamage();

    /**
     * Returns the weapon's weight
     * */
    int getWeight();

    /**
     * Checks if the Engineer can equip this IWeapon.
     * */
    Boolean canEquipEngineer();

    /**
     * Checks if the Knight can equip this IWeapon.
     * */
    Boolean canEquipKnight();

    /**
     * Checks if the Thief can equip this IWeapon.
     * */
    Boolean canEquipThief();

    /**
     * Checks if the Black mage can equip this IWeapon.
     * */
    Boolean canEquipBlackMage();

    /**
     * Checks if the White mage can equip this IWeapon.
     * */
    Boolean canEquipWhiteMage();
}
