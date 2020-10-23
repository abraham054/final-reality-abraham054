package com.github.cc3002.finalreality.model.weaponTest.magicWeaponsTests;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.weaponTypes.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.magicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.weaponTypes.MagicWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StaffTest extends MagicWeaponTest {

    private MagicWeapon expectedStaff;
    private MagicWeapon newStaff;
    private CommonWeapon notExpectedAxe;

    @Override
    public void setType() {
        type = MagicWeaponType.STAFF;
    }

    @BeforeEach
    void setWeapons(){
        expectedStaff = new MagicWeapon(name, weight, damage,
                (MagicWeaponType) type, magicDamage);
        newStaff = new MagicWeapon("new Staff", weight, damage,
                (MagicWeaponType) type, magicDamage);
        notExpectedAxe = new CommonWeapon("Axe",10,10,
                CommonWeaponType.AXE);
    }

    @Test
    void equals(){
        assertEquals(expectedStaff,testedWeapon);
        assertTrue(testedWeapon.equals(testedWeapon));
        assertFalse(testedWeapon.equals(notExpectedAxe));
        assertFalse(testedWeapon.equals(newStaff));
    }
}
