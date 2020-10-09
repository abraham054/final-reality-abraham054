package com.github.cc3002.finalreality.model.WeaponTest.CommonWeaponsTests;

import static org.junit.jupiter.api.Assertions.*;

import com.github.abraham054.finalreality.model.weapon.CommonWeapon.CommonWeapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.CommonWeaponType;
import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AxeTest extends CommonWeaponTest {

    private CommonWeapon expectedAxe;
    private CommonWeapon newAxe;
    private MagicWeapon notExpectedStaff;

    @Override
    public void setType() {
        type = CommonWeaponType.AXE;
    }

    @BeforeEach
    void setWeapons(){
        expectedAxe = new CommonWeapon(name,weight,damage,
                (CommonWeaponType) type);
        newAxe = new CommonWeapon("new Axe",weight,damage,
                (CommonWeaponType) type);
        notExpectedStaff = new MagicWeapon("Staff", 10, 10,
                MagicWeaponType.STAFF, 10);
    }

    @Test
    void equals(){
        assertTrue(testedWeapon.equals(expectedAxe));
        assertFalse(testedWeapon.equals(notExpectedStaff));
        assertFalse(testedWeapon.equals(newAxe));
    }
}
