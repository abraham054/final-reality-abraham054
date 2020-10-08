package com.github.abraham054.finalreality.model.weapon.CommonWeapon;

import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.abraham054.finalreality.model.weapon.WeaponType.CommonWeaponType;

import java.util.Objects;

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
    @Override
    public CommonWeaponType getType(){
        return type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommonWeapon)) {
            return false;
        }
        final CommonWeapon weapon = (CommonWeapon) o;
        return  getName().equals(weapon.getName()) &&
                getWeight() == weapon.getWeight() &&
                getDamage() == weapon.getDamage() &&
                getType() == weapon.getType();
    }

    @Override
    public int hashCode() { return Objects.hash(getName(), getWeight(), getDamage(), getType()); }
}
