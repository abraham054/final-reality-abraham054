package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommonWeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int WEIGHT = 15;
  private static final int DAMAGE = 10;

  private Weapon testAxe;
  private Weapon testSword;
  private Weapon testBow;
  private Weapon testKnife;

  @BeforeEach
  void setUp() {
    testAxe = new CommonWeapon(AXE_NAME, WEIGHT, DAMAGE, CommonWeaponType.AXE);
    testSword = new CommonWeapon(SWORD_NAME, WEIGHT, DAMAGE, CommonWeaponType.SWORD);
    testBow = new CommonWeapon(BOW_NAME, WEIGHT, DAMAGE, CommonWeaponType.BOW);
    testKnife = new CommonWeapon(KNIFE_NAME, WEIGHT, DAMAGE, CommonWeaponType.KNIFE);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new CommonWeapon(AXE_NAME, WEIGHT, DAMAGE, CommonWeaponType.AXE);
    var expectedSword = new CommonWeapon(SWORD_NAME, WEIGHT, DAMAGE, CommonWeaponType.SWORD);
    var expectedBow = new CommonWeapon(BOW_NAME, WEIGHT, DAMAGE, CommonWeaponType.BOW);
    var expectedKnife = new CommonWeapon(KNIFE_NAME, WEIGHT, DAMAGE, CommonWeaponType.KNIFE);

    assertEquals(testAxe, expectedAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(testSword, expectedSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(testBow, expectedBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(testKnife, expectedKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
  }
}