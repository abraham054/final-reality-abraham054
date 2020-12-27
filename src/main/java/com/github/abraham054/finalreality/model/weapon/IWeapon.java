package com.github.abraham054.finalreality.model.weapon;

import com.github.abraham054.finalreality.utils.weaponStates.WeaponState;

import java.util.LinkedList;

public interface IWeapon {

    /**
     * Returns the weapon's name.
     * */
    String getName();

    /**
     * Returns a list with string of the weapon stats (name, weight, etc).
     * */
    LinkedList<String> getStats();

    /**
     * Changes the state of the weapon to available.
     * */
    void unEquip();

    /**
     * Changes the state of the weapon to occupied.
     * */
    void equip();

    /**
     * Returns true if the weapon is available.
     * */
    boolean getIfAvailable();

    /**
     * Returns the weapon state
     * */
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
