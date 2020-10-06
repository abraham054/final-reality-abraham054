package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MagicWeaponTest {
    private static final String STAFF_NAME = "Test Staff";
    private MagicWeapon testStaff;
    private static final int WEIGHT = 15;
    private static final int DAMAGE = 10;
    private static final int MAGIC_DAMAGE = 12;

    @BeforeEach
    void setUp(){
        testStaff = new MagicWeapon(STAFF_NAME, WEIGHT, DAMAGE, MagicWeaponType.STAFF, MAGIC_DAMAGE);
    }

    @Test
    void constructorTest(){
        var expectedStaff = new MagicWeapon(STAFF_NAME, WEIGHT, DAMAGE, MagicWeaponType.STAFF, MAGIC_DAMAGE);
        assertEquals(expectedStaff, testStaff);
        assertEquals(testStaff, expectedStaff);
        assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    }
}
