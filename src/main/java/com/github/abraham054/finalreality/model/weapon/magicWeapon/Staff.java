package com.github.abraham054.finalreality.model.weapon.magicWeapon;

public class Staff extends MagicWeapon {
    /**
     * Creates a Staff.
     *
     * @param name        the magic weapon's name
     * @param weight      the magic weapon's name
     * @param damage      the magic weapon's damage
     * @param magicDamage the magic weapon's magic damage
     */
    public Staff(String name, int weight, int damage, int magicDamage) {
        super(name, weight, damage, magicDamage);
    }

    /**
     * Checks if the Engineer can equip this weapon.
     * */
    @Override
    public Boolean canEquipEngineer() {
        return false;
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
        return getIfAvailable();
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
        return getIfAvailable();
    }
}
