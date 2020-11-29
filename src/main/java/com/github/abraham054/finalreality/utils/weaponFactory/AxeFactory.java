package com.github.abraham054.finalreality.utils.weaponFactory;

import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Axe;

public class AxeFactory extends AbstractWeaponFactory{

    public AxeFactory(String name) {
        super(name);
        this.weight = 13;
        this.damage = 50;
    }

    @Override
    public IWeapon make() {
        return new Axe(name,weight,damage);
    }
}
