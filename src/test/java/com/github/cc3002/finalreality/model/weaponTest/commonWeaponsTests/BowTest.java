package com.github.cc3002.finalreality.model.weaponTest.commonWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Bow;

public class BowTest extends CommonWeaponTest{

    @Override
    public void setTestedWeapon() {
        testedWeapon = new Bow(name,weight,damage);
    }

}
