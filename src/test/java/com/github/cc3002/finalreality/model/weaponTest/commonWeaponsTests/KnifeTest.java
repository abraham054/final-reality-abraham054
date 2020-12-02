package com.github.cc3002.finalreality.model.weaponTest.commonWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Knife;

public class KnifeTest extends CommonWeaponTest {

    @Override
    public void setTestedWeapon() {
        testedAbstractWeapon = new Knife(name,weight,damage);
    }

}
