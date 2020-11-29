package com.github.cc3002.finalreality.model.weaponTest.commonWeaponsTests;

import com.github.cc3002.finalreality.model.weaponTest.AbstractWeaponTest;

abstract class CommonWeaponTest extends AbstractWeaponTest {

  @Override
  public void setName() {name = "Common weapon"; }

  @Override
  public void setWeight() { weight = 20; }

  @Override
  public void setDamage() { damage = 35; }

}