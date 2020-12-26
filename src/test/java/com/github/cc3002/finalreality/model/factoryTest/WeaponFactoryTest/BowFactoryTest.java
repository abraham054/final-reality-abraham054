package com.github.cc3002.finalreality.model.factoryTest.WeaponFactoryTest;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Bow;
import com.github.abraham054.finalreality.utils.weaponFactory.BowFactory;

public class BowFactoryTest extends AbstractWFTest {
    @Override
    public void setName() {
        name = "Arco de elfo";
    }

    @Override
    public void setWeapon() {
        weapon = new Bow(name,10,70);
    }

    @Override
    public void setFactoryWeapon() {
        factoryWeapon = new BowFactory(name).make();
    }
}
