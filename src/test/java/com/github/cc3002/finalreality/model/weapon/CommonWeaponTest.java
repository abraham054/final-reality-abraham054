package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class CommonWeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int SPEED = 10;

  private CommonWeapon testAxe;
  private CommonWeapon testSword;
  private CommonWeapon testBow;
  private CommonWeapon testKnife;

  @BeforeEach
  void setUp() {
    testAxe = new CommonWeapon(AXE_NAME, DAMAGE, SPEED, CommonWeaponType.AXE);
    testSword = new CommonWeapon(SWORD_NAME, DAMAGE, SPEED, CommonWeaponType.SWORD);
    testBow = new CommonWeapon(BOW_NAME, DAMAGE, SPEED, CommonWeaponType.BOW);
    testKnife = new CommonWeapon(KNIFE_NAME, DAMAGE, SPEED, CommonWeaponType.KNIFE);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new CommonWeapon(AXE_NAME, DAMAGE, SPEED, CommonWeaponType.AXE);
    var expectedSword = new CommonWeapon(SWORD_NAME, DAMAGE, SPEED, CommonWeaponType.SWORD);
    var expectedBow = new CommonWeapon(BOW_NAME, DAMAGE, SPEED, CommonWeaponType.BOW);
    var expectedKnife = new CommonWeapon(KNIFE_NAME, DAMAGE, SPEED, CommonWeaponType.KNIFE);

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