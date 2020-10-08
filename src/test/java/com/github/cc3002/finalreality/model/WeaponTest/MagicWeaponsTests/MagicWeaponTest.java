package com.github.cc3002.finalreality.model.WeaponTest.MagicWeaponsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.WeaponType.MagicWeaponType;
import com.github.cc3002.finalreality.model.WeaponTest.AbstractWeaponTest;
import org.junit.jupiter.api.Test;

public abstract class MagicWeaponTest extends AbstractWeaponTest {

    @Override
    public void setName() { name = "Magic Weapon";}

    @Override
    public void setWeight() { weight = 15;}

    @Override
    public void setDamage() { damage = 20;}

    @Override
    public void setTestedWeapon() {
        int magicDamage = 15;
        testedWeapon = new MagicWeapon(name,weight,damage, (MagicWeaponType) type, magicDamage);}

    @Test
    void testMagicDamage(){
        assertEquals(15,testedWeapon.getMagicDamage());
    }
}
