package com.github.abraham054.finalreality.utils.weaponFactory;

import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Sword;

public class SwordFactory extends AbstractWeaponFactory{

    public SwordFactory(String name) {
        super(name);
        this.weight = 15;
        this.damage = 70;
    }

    @Override
    public IWeapon make() {
        return new Sword(name,weight,damage);
    }
}
