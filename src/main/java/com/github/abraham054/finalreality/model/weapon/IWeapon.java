package com.github.abraham054.finalreality.model.weapon;

public interface IWeapon {

    /**
     * Returns the weapon's name
     * */
    String getName();

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
