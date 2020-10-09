package com.github.cc3002.finalreality.model.WeaponTest.CommonWeaponsTests;

import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AxeTest extends CommonWeaponTest {

    private CommonWeapon expectedAxe;
    private MagicWeapon notExpectedStaff;

    @Override
    public void setType() {
        type = CommonWeaponType.AXE;
    }

    @BeforeEach
    void setWeapons(){
        expectedAxe = new CommonWeapon(name,weight,damage,
                (CommonWeaponType) type);
        notExpectedStaff = new MagicWeapon("Staff", 10, 10,
                MagicWeaponType.STAFF, 10);
    }

    @Test
    void equals(){
        assertTrue(testedWeapon.equals(testedWeapon));
        assertTrue(testedWeapon.equals(expectedAxe));
        assertFalse(testedWeapon.equals(notExpectedStaff));
        assertEquals(expectedAxe.hashCode(),testedWeapon.hashCode());
    }
}
