package com.github.cc3002.finalreality.model.WeaponTest.CommonWeaponsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.cc3002.finalreality.model.WeaponTest.AbstractWeaponTest;

abstract class CommonWeaponTest extends AbstractWeaponTest {

  @Override
  public void setName() {name = "Common weapon"; }

  @Override
  public void setWeight() { weight = 20; }

  @Override
  public void setDamage() { damage = 15; }

  @Override
  public void setTestedWeapon() { testedWeapon = new CommonWeapon(name,weight,damage, (CommonWeaponType) type); }

}