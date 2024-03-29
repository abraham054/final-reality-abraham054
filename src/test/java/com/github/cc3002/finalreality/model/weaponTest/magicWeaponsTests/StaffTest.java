package com.github.cc3002.finalreality.model.weaponTest.magicWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Axe;
import com.github.abraham054.finalreality.model.weapon.magicWeapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class StaffTest extends MagicWeaponTest {

    private Staff expectedStaff;
    private Staff newStaff;
    private Axe notExpectedAxe;

    @Override
    public void setTestedWeapon() {
        testedAbstractWeapon = new Staff(name,weight,damage, magicDamage);}

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
        assertEquals(expectedStaff, testedAbstractWeapon);
        assertTrue(testedAbstractWeapon.equals(testedAbstractWeapon));
        assertFalse(testedAbstractWeapon.equals(notExpectedAxe));
        assertFalse(testedAbstractWeapon.equals(newStaff));
    }

    @Test
    @Override
    void testMagicDamage(){
        assertEquals(magicDamage,expectedStaff.getMagicDamage());
    }

    @Test
    public void testStats() {
        LinkedList<String> stats = new LinkedList<>();
        stats.add(expectedStaff.getName());
        stats.add(String.valueOf(expectedStaff.getWeight()));
        stats.add(String.valueOf(expectedStaff.getDamage()));
        stats.add(String.valueOf(expectedStaff.getMagicDamage()));
        stats.add(expectedStaff.getWeaponState().toString());
        assertEquals(stats,testedAbstractWeapon.getStats());
    }
}
