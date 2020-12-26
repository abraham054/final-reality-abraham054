package com.github.abraham054.finalreality.model.weapon.commonWeapon;

import com.github.abraham054.finalreality.model.weapon.AbstractWeapon;

import java.util.LinkedList;
import java.util.Objects;

public abstract class CommonWeapon extends AbstractWeapon {
    /**
     * Creates a common weapon.
     * @param name      the common weapon's name
     * @param weight    the common weapon's weight
     * @param damage    the common weapon's damage
     */
    public CommonWeapon(String name, int weight, int damage) {
        super(name, weight, damage);
    }

    @Override
    public LinkedList<String> getStats() {
        LinkedList<String> stats = new LinkedList<>();
        stats.add(getName());
        stats.add(String.valueOf(getWeight()));
        stats.add(String.valueOf(getDamage()));
        stats.add(weaponState.toString());
        return stats;
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
