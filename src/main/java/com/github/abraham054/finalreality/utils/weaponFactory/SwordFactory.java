package com.github.abraham054.finalreality.utils.weaponFactory;

import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Sword;

public class SwordFactory extends AbstractWeaponFactory{

    /**
     * Creates a Sword factory.
     * @param name the name of the Sword.
     * */
    public SwordFactory(String name) {
        super(name);
        this.weight = 15;
        this.damage = 100;
    }

    /**
     * Creates a new Sword with its predefined values of weight and damage.
     * */
    @Override
    public IWeapon make() {
        return new Sword(name,weight,damage);
    }
}
