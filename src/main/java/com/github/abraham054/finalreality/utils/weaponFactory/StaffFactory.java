package com.github.abraham054.finalreality.utils.weaponFactory;

import com.github.abraham054.finalreality.model.weapon.IWeapon;
import com.github.abraham054.finalreality.model.weapon.magicWeapon.Staff;

public class StaffFactory extends AbstractWeaponFactory{
    private final int magicDamage;
    public StaffFactory(String name) {
        super(name);
        this.magicDamage = 50;
        this.weight = 12;
        this.damage = 20;
    }

    @Override
    public IWeapon make() {
        return new Staff(name,weight,damage,magicDamage);
    }
}
