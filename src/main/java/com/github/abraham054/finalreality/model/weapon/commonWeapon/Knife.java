package com.github.abraham054.finalreality.model.weapon.commonWeapon;

public class Knife extends CommonWeapon{
    /**
     * Creates a Knife.
     *
     * @param name   the common weapon's name
     * @param weight the common weapon's weight
     * @param damage the common weapon's damage
     */
    public Knife(String name, int weight, int damage) {
        super(name, weight, damage);
    }

    /**
     * Checks if the Engineer con equip this weapon.
     * */
    @Override
    public Boolean canEquipEngineer() {
        return false;
    }

    /**
     * Checks if the Knight con equip this weapon.
     * */
    @Override
    public Boolean canEquipKnight() {
        return getIfAvailable();
    }

    /**
     * Checks if the Thief can equip this weapon.
     * */
    @Override
    public Boolean canEquipThief() {
        return false;
    }

    /**
     * Checks if the Black mage can equip this weapon.
     * */
    @Override
    public Boolean canEquipBlackMage() {
        return getIfAvailable();
    }

    /**
     * Checks if the White mage can equip this weapon.
     * */
    @Override
    public Boolean canEquipWhiteMage() {
        return false;
    }
}
