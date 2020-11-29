package com.github.abraham054.finalreality.utils.weaponFactory;

import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Knife;

public class KnifeFactory extends AbstractWeaponFactory{

    public KnifeFactory(String name) {
        super(name);
        this.weight = 11;
        this.damage = 40;
    }

    @Override
    public IWeapon make() {
        return new Knife(name,weight,damage);
    }
}
