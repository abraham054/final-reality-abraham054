package com.github.abraham054.finalreality.utils.weaponFactory;

public abstract class AbstractWeaponFactory implements IWeaponFactory{
    protected final String name;
    protected int weight;
    protected int damage;

    /**
     * Sets the name of the weapon.
     * */
    AbstractWeaponFactory(String name){
        this.name = name;
    }

}
