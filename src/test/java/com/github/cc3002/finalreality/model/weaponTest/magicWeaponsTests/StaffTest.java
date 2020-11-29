package com.github.cc3002.finalreality.model.weaponTest.magicWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Axe;
import com.github.abraham054.finalreality.model.weapon.magicWeapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StaffTest extends MagicWeaponTest {

    private Staff expectedStaff;
    private Staff newStaff;
    private Axe notExpectedAxe;

    @Override
    public void setTestedWeapon() {
        testedWeapon = new Staff(name,weight,damage, magicDamage);}

    @BeforeEach
    void setWeapons(){
        expectedStaff = new Staff(name, weight, damage,
                magicDamage);
        newStaff = new Staff("new Staff", weight, damage,
                magicDamage);
        notExpectedAxe = new Axe("Axe",10,10);
    }

    @Test
    void equals(){
        assertEquals(expectedStaff,testedWeapon);
        assertTrue(testedWeapon.equals(testedWeapon));
        assertFalse(testedWeapon.equals(notExpectedAxe));
        assertFalse(testedWeapon.equals(newStaff));
    }

    @Test
    void testMagicDamage(){
        assertEquals(magicDamage,expectedStaff.getMagicDamage());
    }
}
