package com.github.cc3002.finalreality.model.WeaponTest.CommonWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;

public class AxeTest extends CommonWeaponTest {

    @Override
    public void setType() {
        type = CommonWeaponType.AXE;
    }

    @Override
    public void setTestedWeapon() {
        testedWeapon = new CommonWeapon(name,weight,damage, (CommonWeaponType) type);
    }
}
