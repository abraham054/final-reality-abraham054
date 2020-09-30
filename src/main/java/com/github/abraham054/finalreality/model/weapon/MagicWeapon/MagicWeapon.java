package com.github.abraham054.finalreality.model.weapon;

public class MagicWeapon extends Weapon{
    private final int magicDamage;
    private final MagicWeaponType type;

    /**
     * Creates a magic weapon.
     * @param name
     * @param weight
     * @param type
     * @param magicDamage
     */
    public MagicWeapon(String name, int weight, MagicWeaponType type,int magicDamage) {
        super(name,weight);
        this.type = type;
        this.magicDamage = magicDamage;
    }

    public int getMagicDamage() {
        return magicDamage;
    }

    public MagicWeaponType getType(){
        return type;
    }
}
