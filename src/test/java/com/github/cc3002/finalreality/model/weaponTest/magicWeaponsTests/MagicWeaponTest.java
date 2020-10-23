package com.github.cc3002.finalreality.model.weaponTest.magicWeaponsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.abraham054.finalreality.model.weapon.magicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.weaponTypes.MagicWeaponType;
import com.github.cc3002.finalreality.model.weaponTest.AbstractWeaponTest;
import org.junit.jupiter.api.Test;

public abstract class MagicWeaponTest extends AbstractWeaponTest {

    int magicDamage = 15;

    @Override
    public void setName() { name = "Magic Weapon";}

    @Override
    public void setWeight() { weight = 15;}

    @Override
    public void setDamage() { damage = 20;}

    @Override
    public void setTestedWeapon() {
        testedWeapon = new MagicWeapon(name,weight,damage, (MagicWeaponType) type, magicDamage);}

    @Test
    void testMagicDamage(){
        MagicWeapon magicWeapon = new MagicWeapon(name,weight,damage,(MagicWeaponType) type, magicDamage);
        assertEquals(magicDamage,magicWeapon.getMagicDamage());
    }
}
