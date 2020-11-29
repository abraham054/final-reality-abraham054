package com.github.cc3002.finalreality.model.weaponTest.commonWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Bow;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Sword;

public class SwordTest extends CommonWeaponTest{

    @Override
    public void setTestedWeapon() {
        testedWeapon = new Sword(name,weight,damage);
    }

}
