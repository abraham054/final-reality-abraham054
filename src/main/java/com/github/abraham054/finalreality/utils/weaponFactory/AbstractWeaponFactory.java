package com.github.abraham054.finalreality.utils.weaponFactory;

public abstract class AbstractWeaponFactory implements IWeaponFactory{
    protected final String name;
    protected int weight;
    protected int damage;

    AbstractWeaponFactory(String name){
        this.name = name;
    }

}
