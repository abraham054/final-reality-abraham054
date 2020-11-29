package com.github.cc3002.finalreality.model.weaponTest.commonWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Bow;
import com.github.abraham054.finalreality.model.weapon.commonWeapon.Knife;

public class KnifeTest extends CommonWeaponTest{

    @Override
    public void setTestedWeapon() {
        testedWeapon = new Knife(name,weight,damage);
    }

}
