package com.github.abraham054.finalreality.model.weapon.commonWeapon;

public class Bow extends CommonWeapon{
    /**
     * Creates a Bow.
     *
     * @param name   the common weapon's name
     * @param weight the common weapon's weight
     * @param damage the common weapon's damage
     */
    public Bow(String name, int weight, int damage) {
        super(name, weight, damage);
    }

    /**
     * Checks if the Engineer can equip this weapon.
     * */
    @Override
    public Boolean canEquipEngineer() {
        return true;
    }

    /**
     * Checks if the Knight can equip this weapon.
     * */
    @Override
    public Boolean canEquipKnight() {
        return false;
    }

    /**
     * Checks if the Thief can equip this weapon.
     * */
    @Override
    public Boolean canEquipThief() {
        return true;
    }

    /**
     * Checks if the Black mage can equip this weapon.
     * */
    @Override
    public Boolean canEquipBlackMage() {
        return false;
    }

    /**
     * Checks if the White mage can equip this weapon.
     * */
    @Override
    public Boolean canEquipWhiteMage() {
        return false;
    }
}
