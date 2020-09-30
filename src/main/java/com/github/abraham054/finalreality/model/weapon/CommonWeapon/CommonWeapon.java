package com.github.abraham054.finalreality.model.weapon.CommonWeapon;

import com.github.abraham054.finalreality.model.weapon.Weapon;

public class CommonWeapon extends Weapon {
    private final CommonWeaponType type;
    /**
     * Creates a weapon with a name, a base damage, speed and it's type.
     *
     * @param name
     *     the common weapon's name
     * @param weight
     *     the common weapon's weight
     * @param damage
     *     the common weapon's damage
     * @param type
     *     the common weapon's type
     */
    public CommonWeapon(String name, int weight, int damage, CommonWeaponType type) {
        super(name, weight, damage);
        this.type = type;
    }

    /**
     * Returns the common weapon's type
     * */
    public CommonWeaponType getType(){
        return type;
    }

}
