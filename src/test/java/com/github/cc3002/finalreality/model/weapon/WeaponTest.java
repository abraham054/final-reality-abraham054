package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.abraham054.finalreality.model.weapon.Weapon;
import CommonWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int SPEED = 10;

  private Weapon testAxe;
  private Weapon testStaff;
  private Weapon testSword;
  private Weapon testBow;
  private Weapon testKnife;

  @BeforeEach
  void setUp() {
    testAxe = new Weapon(AXE_NAME, DAMAGE, SPEED, CommonWeaponType.AXE);
    testStaff = new Weapon(STAFF_NAME, DAMAGE, SPEED, CommonWeaponType.STAFF);
    testSword = new Weapon(SWORD_NAME, DAMAGE, SPEED, CommonWeaponType.SWORD);
    testBow = new Weapon(BOW_NAME, DAMAGE, SPEED, CommonWeaponType.BOW);
    testKnife = new Weapon(KNIFE_NAME, DAMAGE, SPEED, CommonWeaponType.KNIFE);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new Weapon(AXE_NAME, DAMAGE, SPEED, CommonWeaponType.AXE);
    var expectedStaff = new Weapon(STAFF_NAME, DAMAGE, SPEED, CommonWeaponType.STAFF);
    var expectedSword = new Weapon(SWORD_NAME, DAMAGE, SPEED, CommonWeaponType.SWORD);
    var expectedBow = new Weapon(BOW_NAME, DAMAGE, SPEED, CommonWeaponType.BOW);
    var expectedKnife = new Weapon(KNIFE_NAME, DAMAGE, SPEED, CommonWeaponType.KNIFE);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
  }
}