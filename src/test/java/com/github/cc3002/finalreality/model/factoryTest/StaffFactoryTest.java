package com.github.cc3002.finalreality.model.factoryTest;

import com.github.abraham054.finalreality.model.weapon.magicWeapon.Staff;
import com.github.abraham054.finalreality.utils.weaponFactory.StaffFactory;

public class StaffFactoryTest extends AbstractWFTest{
    @Override
    public void setName() {
        name = "Cetro de Aghanim";
    }

    @Override
    public void setWeapon() {
        weapon = new Staff(name,12,20,50);
    }

    @Override
    public void setFactoryWeapon() {
        factoryWeapon = new StaffFactory(name).make();
    }
}
