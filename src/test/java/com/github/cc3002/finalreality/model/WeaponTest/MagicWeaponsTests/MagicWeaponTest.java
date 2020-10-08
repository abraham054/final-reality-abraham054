package com.github.cc3002.finalreality.model.WeaponTest.MagicWeaponsTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.abraham054.finalreality.model.weapon.MagicWeapon.MagicWeapon;
import com.github.abraham054.finalreality.model.weapon.WeaponTypes.MagicWeaponType;
import com.github.cc3002.finalreality.model.WeaponTest.AbstractWeaponTest;
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
        assertEquals(15,magicWeapon.getMagicDamage());
    }
}
