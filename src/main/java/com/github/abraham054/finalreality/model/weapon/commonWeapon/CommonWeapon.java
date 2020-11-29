package com.github.abraham054.finalreality.model.weapon.commonWeapon;

import com.github.abraham054.finalreality.model.weapon.Weapon;
import java.util.Objects;

public abstract class CommonWeapon extends Weapon {
    /**
     * Creates a weapon with a name, a base damage, speed and it's type.
     * @param name      the common weapon's name
     * @param weight    the common weapon's weight
     * @param damage    the common weapon's damage
     */
    public CommonWeapon(String name, int weight, int damage) {
        super(name, weight, damage);
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
        return  weapon.hashCode() == hashCode();
    }

    @Override
    public int hashCode() { return Objects.hash(getName(), getWeight(), getDamage()); }
}
