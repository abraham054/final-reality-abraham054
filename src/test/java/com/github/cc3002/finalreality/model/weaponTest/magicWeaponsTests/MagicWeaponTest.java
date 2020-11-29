package com.github.cc3002.finalreality.model.weaponTest.magicWeaponsTests;

import com.github.cc3002.finalreality.model.weaponTest.AbstractWeaponTest;

public abstract class MagicWeaponTest extends AbstractWeaponTest {

    int magicDamage = 15;

    @Override
    public void setName() { name = "Magic Weapon";}

    @Override
    public void setWeight() { weight = 15;}

    @Override
    public void setDamage() { damage = 20;}

}
