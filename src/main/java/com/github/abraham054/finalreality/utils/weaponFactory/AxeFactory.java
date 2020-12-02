package com.github.abraham054.finalreality.utils.weaponFactory;

import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Axe;

public class AxeFactory extends AbstractWeaponFactory{

    /**
     * Creates an Axe factory.
     * @param name the name of the Axe.
     * */
    public AxeFactory(String name) {
        super(name);
        this.weight = 13;
        this.damage = 50;
    }

    /**
     * Creates a new Axe with its predefined values of weight and damage.
     * */
    @Override
    public IWeapon make() {
        return new Axe(name,weight,damage);
    }
}
