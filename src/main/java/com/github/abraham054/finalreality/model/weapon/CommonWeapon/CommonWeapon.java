package com.github.abraham054.finalreality.model.weapon;

public class CommonWeapon extends Weapon{
    private final int damage;
    private final CommonWeaponType type;
    /**
     * Creates a weapon with a name, a base damage, speed and it's type.
     *
     * @param name
     * @param weight
     * @param type
     * @param damage
     */
    public CommonWeapon(String name, int weight, CommonWeaponType type,int damage) {
        super(name, weight);
        this.type = type;
        this.damage = damage;
    }
    public int getDamage(){
        return damage;
    }

    public CommonWeaponType getType(){
        return type;
    }

}
