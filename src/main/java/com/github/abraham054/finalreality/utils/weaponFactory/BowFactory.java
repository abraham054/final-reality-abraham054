package com.github.abraham054.finalreality.utils.weaponFactory;

import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Bow;

public class BowFactory extends AbstractWeaponFactory{

    public BowFactory(String name) {
        super(name);
        this.weight = 10;
        this.damage = 30;
    }

    @Override
    public IWeapon make() {
        return new Bow(name,weight,damage);
    }
}
