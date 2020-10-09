package com.github.cc3002.finalreality.model.WeaponTest.MagicWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaffTest extends MagicWeaponTest {

    private MagicWeapon expectedStaff;
    private CommonWeapon notExpectedAxe;

    @Override
    public void setType() {
        type = MagicWeaponType.STAFF;
    }

    @BeforeEach
    void setWeapons(){
        expectedStaff = new MagicWeapon(name, weight, damage,
                (MagicWeaponType) type, magicDamage);
        notExpectedAxe = new CommonWeapon("Axe",10,10,
                CommonWeaponType.AXE);
    }

    @Test
    void equals(){
        assertEquals(expectedStaff,testedWeapon);
        assertTrue(testedWeapon.equals(testedWeapon));
        assertTrue(testedWeapon.equals(expectedStaff));
        assertFalse(testedWeapon.equals(notExpectedAxe));
        assertEquals(expectedStaff.hashCode(),testedWeapon.hashCode());
    }
}
