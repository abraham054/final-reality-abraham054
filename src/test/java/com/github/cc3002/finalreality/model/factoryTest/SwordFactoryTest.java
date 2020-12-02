package com.github.cc3002.finalreality.model.factoryTest;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Sword;
import com.github.abraham054.finalreality.utils.weaponFactory.SwordFactory;

public class SwordFactoryTest extends AbstractWFTest{
    @Override
    public void setName() {
        name = "Filo del infinito";
    }

    @Override
    public void setWeapon() {
        weapon = new Sword(name,15,70);
    }

    @Override
    public void setFactoryWeapon() {
        factoryWeapon = new SwordFactory(name).make();
    }
}
