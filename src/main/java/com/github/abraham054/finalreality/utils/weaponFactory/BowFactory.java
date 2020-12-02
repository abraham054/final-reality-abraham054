package com.github.abraham054.finalreality.utils.weaponFactory;

import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Bow;

public class BowFactory extends AbstractWeaponFactory{

    /**
     * Creates a Bow factory.
     * @param name the name of the Bow.
     * */
    public BowFactory(String name) {
        super(name);
        this.weight = 10;
        this.damage = 30;
    }

    /**
     * Creates a new Bow with its predefined values of weight and damage.
     * */
    @Override
    public IWeapon make() {
        return new Bow(name,weight,damage);
    }
}
