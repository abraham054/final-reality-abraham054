package com.github.cc3002.finalreality.model.factoryTest.WeaponFactoryTest;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Knife;
import com.github.abraham054.finalreality.utils.weaponFactory.KnifeFactory;

public class KnifeFactoryTest extends AbstractWFTest {
    @Override
    public void setName() {
        name = "Cuchilllo de vandido";
    }

    @Override
    public void setWeapon() {
        weapon = new Knife(name,11,70);
    }

    @Override
    public void setFactoryWeapon() {
        factoryWeapon = new KnifeFactory(name).make();
    }
}
