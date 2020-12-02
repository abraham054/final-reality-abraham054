package com.github.cc3002.finalreality.model.weaponTest.commonWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Sword;

public class SwordTest extends CommonWeaponTest {

    @Override
    public void setTestedWeapon() {
        testedAbstractWeapon = new Sword(name,weight,damage);
    }

}
