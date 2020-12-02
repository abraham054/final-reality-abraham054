package com.github.cc3002.finalreality.model.factoryTest;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Axe;
import com.github.abraham054.finalreality.utils.weaponFactory.AxeFactory;

public class AxeFactoryTest extends AbstractWFTest{
    @Override
    public void setName() {
        name = "Hacha sin filo";
    }

    @Override
    public void setWeapon() {
        weapon = new Axe(name,13,50);
    }

    @Override
    public void setFactoryWeapon() {
        factoryWeapon = new AxeFactory(name).make();
    }
}
