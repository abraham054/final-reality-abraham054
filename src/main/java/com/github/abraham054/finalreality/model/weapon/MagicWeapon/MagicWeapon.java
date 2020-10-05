package com.github.abraham054.finalreality.model.weapon.MagicWeapon;

import com.github.abraham054.finalreality.model.weapon.Weapon;

import java.util.Objects;

public class MagicWeapon extends Weapon {
    private final int magicDamage;
    private final MagicWeaponType type;

    /**
     * Creates a magic weapon.
     * @param name
     *     the magic weapon's name
     * @param weight
     *     the magic weapon's name
     * @param damage
     *     the magic weapon's damage
     * @param type
     *     the magic weapon's type
     * @param magicDamage
     *     the magic weapon's magic damage
     */
    public MagicWeapon(String name, int weight, int damage, MagicWeaponType type, int magicDamage) {
        super(name,weight,damage);
        this.type = type;
        this.magicDamage = magicDamage;
    }

    /**
     * Returns the magic weapon's damage
     * */
    public int getMagicDamage() {
        return magicDamage;
    }

    /**
     * Returns the magic weapon's type
     * */
    public MagicWeaponType getType(){
        return type;
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
        return getName().equals(weapon.getName()) &&
                getWeight() == weapon.getWeight() &&
                getDamage() == weapon.getDamage() &&
                getType() == weapon.getType() &&
                getMagicDamage() == weapon.getMagicDamage();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getWeight(), getDamage(), getType(),getMagicDamage());
    }
}
