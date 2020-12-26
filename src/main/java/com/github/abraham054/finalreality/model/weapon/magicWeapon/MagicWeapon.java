package com.github.abraham054.finalreality.model.weapon.magicWeapon;

import com.github.abraham054.finalreality.model.weapon.AbstractWeapon;

import java.util.LinkedList;
import java.util.Objects;

public abstract class MagicWeapon extends AbstractWeapon {
    private final int magicDamage;

    /**
     * Creates a magic weapon.
     *
     * @param name          the magic weapon's name
     * @param weight        the magic weapon's name
     * @param damage        the magic weapon's damage
     * @param magicDamage   the magic weapon's magic damage
     */
    protected MagicWeapon(String name, int weight, int damage, int magicDamage) {
        super(name,weight,damage);
        this.magicDamage = magicDamage;
    }

    /**
     * Returns the magic weapon's damage
     * */
    public int getMagicDamage() {
        return magicDamage;
    }

    @Override
    public LinkedList<String> getStats() {
        LinkedList<String> stats = new LinkedList<>();
        stats.add(getName());
        stats.add(String.valueOf(getWeight()));
        stats.add(String.valueOf(getDamage()));
        stats.add(String.valueOf(getMagicDamage()));
        stats.add(weaponState.toString());
        return stats;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MagicWeapon)) {
            return false;
        }
        final MagicWeapon weapon = (MagicWeapon) o;
        return weapon.hashCode() == hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight(), getDamage(),getMagicDamage());
    }
}
