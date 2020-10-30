package com.github.cc3002.finalreality.model.weaponTest.CommonWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.cc3002.finalreality.model.weaponTest.AbstractWeaponTest;

abstract class CommonWeaponTest extends AbstractWeaponTest {

  @Override
  public void setName() {name = "Common weapon"; }

  @Override
  public void setWeight() { weight = 20; }

  @Override
  public void setDamage() { damage = 35; }

  @Override
  public void setTestedWeapon() { testedWeapon = new CommonWeapon(name,weight,damage, (CommonWeaponType) type); }

}