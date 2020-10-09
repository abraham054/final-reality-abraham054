package com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.MagicPlayerTests;

import com.github.cc3002.finalreality.model.CharacterTest.PlayerTest.AbstractPlayerTest;

public abstract class MagicPlayerTest extends AbstractPlayerTest {
    protected int mana;

    abstract void setMana();

    @Override
    public void setDefense() {
        defense = 10;
    }

    @Override
    public void setHealthPoints() {
        healthPoints = 70;
    }

}
