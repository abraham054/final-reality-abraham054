package com.github.cc3002.finalreality.model.character.PlayerTest.MagicPlayerTests;

import com.github.abraham054.finalreality.model.weapon.Weapon;
import com.github.cc3002.finalreality.model.character.PlayerTest.AbstractPlayerTest;

public abstract class MagicPlayertTest extends AbstractPlayerTest {
    protected int mana;

    @Override
    public void setDefense() {
        defense = 10;
    }

    @Override
    public void setHealthPoints() {
        healthPoints = 70;
    }

    public void setMana(){
        mana = 100;
    }


}
