package com.github.cc3002.finalreality.model.weaponTest.commonWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.commonWeapon.Axe;
import com.github.abraham054.finalreality.model.weapon.magicWeapon.Staff;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AxeTest extends CommonWeaponTest {

    private Axe expectedAxe;
    private Axe newAxe;
    private Staff notExpectedStaff;

    @Override
    public void setTestedWeapon() {
        testedAbstractWeapon = new Axe(name,weight,damage);
    }

    @BeforeEach
    void setWeapons(){
        expectedAxe = new Axe(name,weight,damage);
        newAxe = new Axe("new Axe",weight,damage);
        notExpectedStaff = new Staff("Staff", 10, 10, 10);
    }

    @Test
    void equals(){
        assertTrue(testedAbstractWeapon.equals(expectedAxe));
        assertFalse(testedAbstractWeapon.equals(notExpectedStaff));
        assertFalse(testedAbstractWeapon.equals(newAxe));
    }

}
