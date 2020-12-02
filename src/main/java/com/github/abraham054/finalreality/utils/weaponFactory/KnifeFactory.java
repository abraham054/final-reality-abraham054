package com.github.abraham054.finalreality.utils.weaponFactory;

import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Knife;

public class KnifeFactory extends AbstractWeaponFactory{

    /**
     * Creates a Knife factory.
     * @param name the name of the Knife.
     * */
    public KnifeFactory(String name) {
        super(name);
        this.weight = 11;
        this.damage = 40;
    }

    /**
     * Creates a new Knife with its predefined values of weight and damage.
     * */
    @Override
    public IWeapon make() {
        return new Knife(name,weight,damage);
    }
}
